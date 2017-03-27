package com.jorisrietveld.model.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jorisrietveld.exception.EntityManagerException;
import com.jorisrietveld.model.Entity.*;
import com.jorisrietveld.model.EntityManager;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 20-03-2017 15:25
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
public abstract class DAO
{
    static final String DATABASE_NAME="SpeedboatRentalSite";

    /**
     * The entity name of the data access object.
     */
    public ENTITY_NAME DAOEntityNAME;

    /**
     * The column/attribute names of the table/entity
     */
    private ArrayList<String> columnNames;

    /**
     * The connection to the database server.
     */
    protected Connection connection;

    /**
     * An instance of the entity manager used to receive data from the database.
     */
    private EntityManager entityManager;

    /**
     * An database result set that contains data from the database.
     */
    protected ResultSet currentResultSet;

    /**
     * An enumeration of the entities/tables that exists in the database
     */
    public enum ENTITY_NAME
    {
        CUSTOMER("Customer"),
        DAMAGE_REPORT("Damage Report"),
        RENTAL("Rental"),
        USER("User"),
        SPEEDBOAT("Speedboat");
        private String displayName;

        ENTITY_NAME(String name)
        {
            this.displayName=name;
        }

        public String getName()
        {
            return this.displayName;
        }
    }

    /**
     * Data Access Object constructor for initiating an simple data access object.
     *
     * @param DAOEntityNAME The name of the entity/table
     */
    DAO(ENTITY_NAME DAOEntityNAME)
    {
        this.DAOEntityNAME=DAOEntityNAME;
    }

    /**
     * Data Access Object constructor for initiating the data access object that can fetch data from the
     * connected database server.
     *
     * @param DAOEntityNAME The name of the entity/table
     * @param columnNames   The names of the columns/attributes that the table/entity has.
     */
    DAO(ENTITY_NAME DAOEntityNAME, ArrayList<String> columnNames)
    {
        this.DAOEntityNAME=DAOEntityNAME;
        this.columnNames=columnNames;
    }

    /**
     * Simple lambada function to surround strings with backtick characters.
     */
    protected Function<String, String> addBackticks=s -> new StringBuilder(s.length() + 2).append('`').append(s).append('`').toString();

    /**
     * Simple lambada function to build an comma separated column list with the columns encapsulated with backticks.
     */
    protected Function<ArrayList<String>, String> buildColumnList=(c) -> c.stream().map(addBackticks).collect(Collectors.joining(", "));

    /**
     * Constructs an new Entity from an database result set.
     */
    protected abstract Entity createEntityFromResultSet() throws SQLException, EntityManagerException;

    /**
     * Constructs an new Entity collection from an database result set.
     */
    protected ArrayList<Entity> createEntitiesFromResultSet() throws SQLException, EntityManagerException
    {
        ArrayList<Entity> entities=new ArrayList<>();

        while(currentResultSet.next())
        {
            entities.add(createEntityFromResultSet());
        }
        return entities;
    }

    /**
     * Gets an entity from the database
     *
     * @param entityId The unique identification code of the record.
     */
    public Entity getById(int entityId) throws SQLException, EntityManagerException
    {
        PreparedStatement preparedStatement=connection.prepareStatement(String.format(
                "SELECT %s FROM `%2$s`.`%3$s` WHERE `%3$s`.`id` = ?",
                buildColumnList.apply(columnNames),
                DATABASE_NAME,
                DAOEntityNAME.getName()
        ));

        preparedStatement.setInt(1, entityId);
        ResultSet queryResult=preparedStatement.executeQuery();

        if(!queryResult.isBeforeFirst())
        {
            this.currentResultSet=queryResult;
            return createEntityFromResultSet();
        }
        return null;
    }

    /**
     * Function to get all the entities from an certain entity type.
     *
     * @throws SQLException
     */
    public ArrayList<Entity> getAll() throws SQLException, EntityManagerException
    {
        PreparedStatement preparedStatement=connection.prepareStatement(String.format(
                "SELECT %s FROM `%s`.`%s`",
                buildColumnList.apply(columnNames),
                DATABASE_NAME,
                DAOEntityNAME.getName()
        ));

        ResultSet queryResult=preparedStatement.executeQuery();

        if(!queryResult.isBeforeFirst())
        {
            this.currentResultSet=queryResult;
            return createEntitiesFromResultSet();
        }
        return null;
    }

    /**
     * Gets an entity collection from entities that matches a certain condition.
     *
     * @param whereClause The sql where clause string without the WHERE keyword.
     * @param parameters  An array list wil the parameter values that will get bound to the placeholders in the where clause.
     * @throws SQLException
     * @throws EntityManagerException
     */
    public ArrayList<Entity> getWhere(String whereClause, ArrayList<Object> parameters) throws SQLException, EntityManagerException
    {
        PreparedStatement preparedStatement=connection.prepareStatement(String.format(
                "SELECT %s FROM `%s`.`%s` WHERE %s",
                buildColumnList.apply(columnNames),
                DATABASE_NAME,
                DAOEntityNAME.getName(),
                whereClause
        ));
        for(int parameterCounter=1; parameterCounter <= parameters.size(); parameterCounter++)
        {
            preparedStatement.setObject(parameterCounter, parameters.get(parameterCounter - 1));
        }

        this.currentResultSet=preparedStatement.executeQuery();

        if(!this.currentResultSet.isBeforeFirst())
        {
            return createEntitiesFromResultSet();
        }

        return null;
    }

    /**
     * Gets an entity collection from entities that matches a certain condition.
     *
     * @param whereClause The sql where clause string without the WHERE keyword.
     * @param parameters  An array list wil the parameter values that will get bound to the placeholders in the where clause.
     * @throws SQLException
     * @throws EntityManagerException
     */
    public Entity getOneWhere(String whereClause, ArrayList<Object> parameters) throws SQLException, EntityManagerException
    {
        PreparedStatement preparedStatement=connection.prepareStatement(String.format(
                "SELECT %s FROM `%s`.`%s` WHERE %s LIMIT 1",
                buildColumnList.apply(columnNames),
                DATABASE_NAME,
                DAOEntityNAME.getName(),
                whereClause
        ));

        for(int parameterCounter=1; parameterCounter <= parameters.size(); parameterCounter++)
        {
            preparedStatement.setObject(parameterCounter, parameters.get(parameterCounter - 1));
        }

        this.currentResultSet=preparedStatement.executeQuery();

        if(!this.currentResultSet.isBeforeFirst())
        {
            return createEntityFromResultSet();
        }

        return null;
    }

    /**
     * Gets an entity collection of entities that were created within an certain time range.
     *
     * @param startDate The start date of the range.
     * @param endDate   The end date of the range.
     * @throws SQLException
     * @throws EntityManagerException
     */
    public ArrayList<Entity> getByAddedRange(Timestamp startDate, Timestamp endDate) throws SQLException, EntityManagerException
    {
        return getWhere(" `%s`.`dateAdded` BETWEEN ? AND ? ", new ArrayList<Object>()
        {{
            add(startDate);
            add(endDate);
        }});
    }

    /**
     * An simpler implementation of the method above, it gets the records from an certain date to NOW()
     * @param fromDate The start date
     * @throws SQLException
     * @throws EntityManagerException
     */
    public ArrayList<Entity> getByAddedRange( Timestamp fromDate ) throws SQLException, EntityManagerException
    {
        return getByAddedRange( fromDate, new Timestamp(System.currentTimeMillis()) );
    }

    /**
     * Gets an entity collection of entities that were modified within an certain time range.
     * @param startDate The start date of the range.
     * @param endDate The end date of the range.
     * @throws SQLException
     * @throws EntityManagerException
     */
    public ArrayList<Entity> getByModifiedRange( Timestamp startDate, Timestamp endDate ) throws SQLException, EntityManagerException
    {
        return getWhere(" `%s`.`dateModified` BETWEEN ? AND ? ", new ArrayList<Object>()
        {{
            add(startDate);
            add(endDate);
        }});
    }

    /**
     * An simpler implementation of the method above, it gets the records from an certain date to NOW()
     * @param fromDate The start date
     * @throws SQLException
     * @throws EntityManagerException
     */
    public ArrayList<Entity> getByModifiedRange( Timestamp fromDate ) throws SQLException, EntityManagerException
    {
        return getByModifiedRange( fromDate, new Timestamp(System.currentTimeMillis()) );
    }

    /**
     * Gets the name of the entity/table that the DAO manages.
     *
     * @return ENTITY_NAME
     */
    public ENTITY_NAME getName()
    {
        return this.DAOEntityNAME;
    }

    /**
     * Gets the column names of the table/entity
     *
     * @return ArrayList<String>
     */
    public ArrayList<String> getColumnNames()
    {
        return columnNames;
    }

    /**
     * Saves the database connection to the DAO so it can be used to fetch data.
     *
     * @param connection The active connection to the database server.
     * @return DAO return the DAO so you can chain instantiate it.
     */
    public DAO setConnection(Connection connection)
    {
        this.connection=connection;
        return this;
    }

    /**
     * Saves the entity manager so it can fetch data from different DAO's and get the database connection.
     *
     * @param entityManager The entity manager that can create all DAO's.
     * @return DAO return the DAO so you can chain instantiate it.
     */
    public DAO setEntityManager(EntityManager entityManager)
    {
        this.entityManager=entityManager;
        return this;
    }

    /**
     * Gets the entity manager for creating DAO's that in turn can fetch data from the database server.
     *
     * @return EntityManager
     */
    public EntityManager getEntityManager()
    {
        return entityManager;
    }

    /** ================================================================================================================
     *                              Some experiments with functional programming                                       *
     * =================================================================================================================
     *
     // Experiment with higher level lambada functions ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     public Function<ArrayList<String>, String> buildColumnString= (columnList) ->
     columnList.stream().map( column ->
     new StringBuilder(column.length() + 2).append("`").append(column).append("`").toString()
     ).collect( Collectors.joining(", "));

     // Experiment with an short higher level lambada function +++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     public Function<ArrayList<String>, String> a=l->l.stream().map(c->("`"+c+"`")).collect(Collectors.joining(", "));

     // An non functional approach +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     public String buildColumnString( ArrayList<String> columns)
     {
     StringBuilder columnString = new StringBuilder();
     int iterationCounter = 1;

     for( String column : columns )
     {
     columnString.append( "`" ).append( column ).append( "`" + ( iterationCounter < columns.size() ? ", " : " ") )
     }
     return columnString;
     }

     */
}
