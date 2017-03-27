package com.jorisrietveld.model.DAO;

import com.jorisrietveld.model.Entity.Entity;
import com.jorisrietveld.model.Entity.SpeedBoat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 20-03-2017 15:09
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
public class SpeedboatDAO extends DAO
{
    private static final String TABLE_NAME = "Speedboat";
    private static final ArrayList<String> TABLE_COLUMNS = new ArrayList<String>() {{
        add("id");
        add("weight");
        add("horsePower");
        add("boatNumber");
        add("length");
        add("rent");
        add("dateAdded");
        add("dateModified");
    }};

    public SpeedboatDAO()
    {
        super(ENTITY_NAME.SPEEDBOAT, TABLE_COLUMNS );
    }

    /**
     * Constructs an new Entity collection from an database result set.
     * @param resultSet The database query result.
     */
   /* protected ArrayList<Entity> createEntitiesFromResultSet(ResultSet resultSet ) throws SQLException
    {
        return new ArrayList<Entity>();
    }*/

    /**
     * Constructs an new Entity from an database result set.
     */
    protected Entity createEntityFromResultSet() throws SQLException
    {
        return new SpeedBoat(
                currentResultSet.getInt( "id" ),
                currentResultSet.getInt( "weight" ),
                currentResultSet.getInt("horsePower"),
                currentResultSet.getInt("boatNumber"),
                currentResultSet.getInt("length"),
                currentResultSet.getBigDecimal("rent"),
                currentResultSet.getTimestamp( "dateAdded"),
                currentResultSet.getTimestamp( "dateModified")
        );
    }

}
