package com.jorisrietveld.model;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 21-03-2017 19:12
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

import com.jorisrietveld.model.entity.Entity;

import java.sql.*;

/**
 * This class us for persisting entity data to the database.
 */
public class EntityManager
{
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_HOST = "127.0.0.1";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "toor";
    private static final String DATABASE_PORT = "3306";
    private static final String DATABASE_CHARSET = "UTF-8";
    private static final String DATABASE_SCHEMA = "SpeedboatRentalSite";

    private String databaseConnectString = "";
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public EntityManager()
    {

    }

    public void readDataBase() throws Exception
    {
        try{
            Class.forName( this.DATABASE_DRIVER );

            this.connection =DriverManager.getConnection( String.format(
                    "jdbc:mysql://%s/%s?user=%s&password=%s",
                    DATABASE_HOST,
                    DATABASE_SCHEMA,
                    DATABASE_USER,
                    DATABASE_PASSWORD
            ));
        }
        catch( Exception e )
        {
            System.out.print(e.getMessage() );
        }
    }

}
