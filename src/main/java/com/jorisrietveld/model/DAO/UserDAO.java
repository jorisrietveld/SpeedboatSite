package com.jorisrietveld.model.DAO;

import com.jorisrietveld.exception.EntityManagerException;
import com.jorisrietveld.model.Entity.Entity;
import com.jorisrietveld.model.Entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 22-03-2017 11:45
 * Licence: GPLv3 - General public licence version 3.
 * Teachers: Rob loves and  Winnie van Schilt
 * <p>
 * ======================================================================
 * ===               Java final assignment number: 10                 ===
 * ======================================================================
 * An short description about the project
 * ----------------------------------------------------------------------
 * An speedboat rental company wants to digitize there rental records.
 * The company owns 10 speedboats and they want to record what speedboat
 * get rented on what date, the amount of fuel that was used, the total
 * profit earned and the damage that the speedboat accumulated during
 * the speedboat rental.
 */
public class UserDAO extends DAO
{
    public static final ArrayList<String> TABLE_COLUMNS=new ArrayList<String>()
    {{
        add("id");
        add("username");
        add("password");
        add("dateAdded");
        add("dateModified");
    }};

    public UserDAO()
    {
        super(ENTITY_NAME.USER, TABLE_COLUMNS);
    }

    /**
     * Constructs an new Entity from an database result set.
     */
    protected Entity createEntityFromResultSet() throws SQLException
    {
        return new User(
                currentResultSet.getInt("id"),
                currentResultSet.getString("username"),
                currentResultSet.getString("password"),
                currentResultSet.getTimestamp("dateAdded"),
                currentResultSet.getTimestamp("dateModified")
        );
    }

    protected User getByUsername(String username) throws SQLException, EntityManagerException
    {
        PreparedStatement statement = connection.prepareStatement( String.format(
                "SELECT %s FROM `%2$s`.`%3$s` WHERE `%3$s`.`username` = ? ",
                buildColumnList.apply(TABLE_COLUMNS),
                DATABASE_NAME,
                DAOEntityNAME.getName()
        ));

        currentResultSet = statement.executeQuery();

        if( !currentResultSet.isBeforeFirst() )
        {
            Entity user = createEntityFromResultSet();
            if( user instanceof User )
            {
                return (User)user;
            }
        }
        return null;
    }

}
