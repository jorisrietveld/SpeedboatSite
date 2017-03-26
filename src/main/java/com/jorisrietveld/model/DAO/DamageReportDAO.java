package com.jorisrietveld.model.DAO;

import com.jorisrietveld.model.Entity.DamageReport;
import com.jorisrietveld.model.Entity.Rental;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private static final String TABLE_NAME = "DamageReport";
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
        super( Name.DAMAGE_REPORT, TABLE_COLUMNS );
    }

    public DamageReport createDamageReportFromResultSet(ResultSet resultSet) throws Exception
    {
        return new DamageReport(
                resultSet.getInt("id" ),
                (Rental)getEntityManager().find( Name.RENTAL ).getById( resultSet.getInt("rentalId") ),
                resultSet.getString( "title"),
                resultSet.getString("description"),
                resultSet.getBigDecimal( "cost"),
                resultSet.getTimestamp( "dateAdded" ),
                resultSet.getTimestamp("dateModified")
        );
    }

    public DamageReport getById( int id )
    {
        try
        {
            String sqlQuery=String.format("SELECT %s FROM `%s`.`%s` WHERE id = ? ", String.join(",", TABLE_COLUMNS), DATABASE_NAME, TABLE_NAME);

            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt( 1, id );

            ResultSet dbCustomer = statement.executeQuery();

            return createDamageReportFromResultSet( dbCustomer );
        }
        catch( Exception e )
        {

        }
        return null;
    }
}
