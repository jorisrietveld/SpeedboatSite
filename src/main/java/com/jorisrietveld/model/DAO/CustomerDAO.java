package com.jorisrietveld.model.DAO;

import com.jorisrietveld.model.Entity.Customer;
import com.jorisrietveld.model.Entity.Entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 22-03-2017 11:40
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
public class CustomerDAO extends DAO
{
    /**
     * The names of the columns that the Customer entity has.
     */
    private static final ArrayList<String> COLUMNS = new ArrayList<String>(){{
        add("id");
        add("firstName");
        add("lastName");
        add("email");
        add("telephoneNumber");
        add("dateAdded");
        add("dateModified");
    }};

    /**
     * Customer constructor for initiating the Customer Data Access Object.
     */
    public CustomerDAO()
    {
        super(ENTITY_NAME.CUSTOMER, COLUMNS);
    }


    /**
     * Creates an Customer object from an database result set.
     * @param resultSet The database result set containing an customer.
     */
    protected Customer createEntityFromResultSet(ResultSet resultSet)throws SQLException
    {
        return new Customer(
                resultSet.getInt("id"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getString("email"),
                resultSet.getString("telephoneNumber"),
                resultSet.getTimestamp("dateAdded"),
                resultSet.getTimestamp("dateModified")
        );
    }

    /**
     * Constructs an new Customer collection from an database result set.
     * @param resultSet The database query result.
     */
    protected ArrayList<Entity> createEntitiesFromResultSet(ResultSet resultSet)throws SQLException
    {
        ArrayList<Entity> customers = new ArrayList<>();

        while(resultSet.next())
        {
            customers.add(new Customer(
                    resultSet.getInt("id"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("email"),
                    resultSet.getString("telephoneNumber"),
                    resultSet.getTimestamp("dateAdded"),
                    resultSet.getTimestamp("dateModified")
            ));
        }
        return customers;
    }
}
