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

import com.jorisrietveld.exception.EntityManagerException;
import com.jorisrietveld.model.DAO.*;

import java.sql.*;
import java.util.HashMap;

/**
 * This class us for persisting entity data to the database.
 */
public class EntityManager
{
    private static final String DATABASE_DRIVER="com.mysql.jdbc.Driver";
    private static final String DATABASE_HOST="127.0.0.1";
    private static final String DATABASE_USER="root";
    private static final String DATABASE_PASSWORD="toor";
    private static final String DATABASE_PORT="3306";
    private static final String DATABASE_SCHEMA="SpeedboatRentalSite";

    private Connection connection=null;
    private HashMap<DAO.ENTITY_NAME, DAO> storedRepos=new HashMap<>();

    /**
     * EntityName manager constructor, this constructor initiates the manager and opens an connection to the
     * database server.
     */
    public EntityManager()
    {
        openDatabaseConnection();
    }

    public DAO find(DAO.ENTITY_NAME entityEntityNAME) throws EntityManagerException
    {
        switch(entityEntityNAME)
        {
            case CUSTOMER:
                return storedRepos.containsKey( DAO.ENTITY_NAME.CUSTOMER ) ? storedRepos.get( DAO.ENTITY_NAME.CUSTOMER ) : storeRepo(new CustomerDAO());

            case DAMAGE_REPORT:
                return storedRepos.containsKey(DAO.ENTITY_NAME.DAMAGE_REPORT) ? storedRepos.get(DAO.ENTITY_NAME.DAMAGE_REPORT) : storeRepo(new DamageReportDAO());

            case RENTAL:
                return storedRepos.containsKey(DAO.ENTITY_NAME.RENTAL) ? storedRepos.get(DAO.ENTITY_NAME.RENTAL) : storeRepo(new RentalDAO());

            case SPEEDBOAT:
                return storedRepos.containsKey(DAO.ENTITY_NAME.SPEEDBOAT) ? storedRepos.get(DAO.ENTITY_NAME.SPEEDBOAT) : storeRepo(new SpeedboatDAO());

            case USER:
                return storedRepos.containsKey(DAO.ENTITY_NAME.USER) ? storedRepos.get(DAO.ENTITY_NAME.USER) : storeRepo(new UserDAO());

            default:
                throw new EntityManagerException(String.format("DAO %s is not an valid DAO.", entityEntityNAME.getName() ));
        }
    }

    public DAO storeRepo(DAO newDAO)
    {
        storedRepos.put( newDAO.getName() , newDAO.setConnection(this.connection).setEntityManager(this));
        return newDAO;
    }

    public void openDatabaseConnection()
    {
        try
        {
            Class.forName(DATABASE_DRIVER);

            this.connection=DriverManager.getConnection(String.format(
                    "jdbc:mysql://%s:%s/%s?user=%s&password=%s",
                    DATABASE_HOST,
                    DATABASE_PORT,
                    DATABASE_SCHEMA,
                    DATABASE_USER,
                    DATABASE_PASSWORD
            ));
        }
        catch(Exception e)
        {
            // do nothing
        }
    }
}
