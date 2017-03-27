package com.jorisrietveld.model.DAO;

import com.jorisrietveld.exception.EntityManagerException;
import com.jorisrietveld.model.Entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 18-03-2017 11:15
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
public class RentalDAO extends DAO
{
    private static final String TABLE_NAME="Rental";
    private static final ArrayList<String> TABLE_COLUMNS=new ArrayList<String>()
    {{
        add("id");
        add("speedboatId");
        add("customerId");
        add("fuelLevelStart");
        add("fuelLevelEnd");
        add("currentlyRented");
        add("rentedStartDate");
        add("rentedEndDate");
        add("dateAdded");
        add("dateModified");
    }};

    public RentalDAO()
    {
        super(ENTITY_NAME.RENTAL, TABLE_COLUMNS);
    }

    /**
     * Constructs an new Entity collection from an database result set.
     *
     * @param resultSet The database query result.
     */
    /*protected ArrayList<Entity> createEntitiesFromResultSet(ResultSet resultSet) throws SQLException, EntityManagerException
    {
        ArrayList<Entity> entities=new ArrayList<>();

        while(resultSet.next())
        {
            entities.add(
                    new Rental(
                            resultSet.getInt("id"),
                            (SpeedBoat) getEntityManager().find(ENTITY_NAME.SPEEDBOAT).getById(resultSet.getInt("speedboatId")),
                            (Customer) getEntityManager().find(ENTITY_NAME.CUSTOMER).getById(resultSet.getInt("customerId")),
                            resultSet.getInt("fuelLevelStart"),
                            resultSet.getInt("fuelLevelEnd"),
                            resultSet.getBoolean("currentlyRented"),
                            resultSet.getTimestamp("rentedStartDate"),
                            resultSet.getTimestamp("rentedEndDate"),
                            getEntityManager().find(ENTITY_NAME.DAMAGE_REPORT).getWhere("rentalId = ?",
                                    new ArrayList<Object>()
                                    {{
                                        add(resultSet.getInt("rentalId"));
                                    }}
                            ),
                            resultSet.getTimestamp("dateAdded"),
                            resultSet.getTimestamp("dateModified")
                    )
            );
        }

        return entities;
    }*/

    /**
     * Constructs an new Entity from an database result set.
     */
    protected Entity createEntityFromResultSet( ) throws SQLException, EntityManagerException
    {
        return new Rental(
                currentResultSet.getInt("id"),
                (SpeedBoat) getEntityManager().find(ENTITY_NAME.SPEEDBOAT).getById(currentResultSet.getInt("speedboatId")),
                (Customer) getEntityManager().find(ENTITY_NAME.CUSTOMER).getById(currentResultSet.getInt("customerId")),
                currentResultSet.getInt("fuelLevelStart"),
                currentResultSet.getInt("fuelLevelEnd"),
                currentResultSet.getBoolean("currentlyRented"),
                currentResultSet.getTimestamp("rentedStartDate"),
                currentResultSet.getTimestamp("rentedEndDate"),
                getEntityManager().find(ENTITY_NAME.DAMAGE_REPORT).getWhere("rentalId = ?",
                        new ArrayList<Object>()
                        {{
                            add(currentResultSet.getInt("rentalId"));
                        }}
                ),
                currentResultSet.getTimestamp("dateAdded"),
                currentResultSet.getTimestamp("dateModified")
        );
    }
}
