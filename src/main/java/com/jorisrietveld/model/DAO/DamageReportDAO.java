package com.jorisrietveld.model.DAO;

import com.jorisrietveld.exception.EntityManagerException;
import com.jorisrietveld.model.Entity.Customer;
import com.jorisrietveld.model.Entity.DamageReport;
import com.jorisrietveld.model.Entity.Entity;
import com.jorisrietveld.model.Entity.Rental;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 20-03-2017 15:33
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
public class DamageReportDAO extends DAO
{
    /**
     * Initiate the default table settings for the DamageReport Repo.
     */
    private static final ArrayList<String> TABLE_COLUMNS = new ArrayList<String>() {{
        add("id");
        add("rentalId");
        add("title");
        add("description");
        add("cost");
        add("dateAdded");
        add("dateModified");
    }};

    public DamageReportDAO()
    {
        super( ENTITY_NAME.DAMAGE_REPORT, TABLE_COLUMNS );
    }

    /**
     * Constructs an new Entity from an database result set.
     */
    protected Entity createEntityFromResultSet() throws SQLException, EntityManagerException
    {
        return new DamageReport(
                currentResultSet.getInt("id" ),
                (Rental)getEntityManager().find( ENTITY_NAME.RENTAL ).getById( currentResultSet.getInt("rentalId") ),
                currentResultSet.getString( "title"),
                currentResultSet.getString("description"),
                currentResultSet.getBigDecimal( "cost"),
                currentResultSet.getTimestamp( "dateAdded" ),
                currentResultSet.getTimestamp("dateModified")
        );
    }
}
