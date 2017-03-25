package com.jorisrietveld.model.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jorisrietveld.model.Entity.Entity;
import com.jorisrietveld.model.Entity.SpeedBoat;
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
public abstract class Repository
{
    protected static final String DATABASE_NAME = "SpeedboatRentalSite";

    protected String repositoryName;
    protected String tableName;
    protected ArrayList<String> columnNames;
    protected Connection connection;
    protected EntityManager entityManager;

    public Repository()
    {
        this.repositoryName="";
    }

    public Repository(String repositoryName)
    {
        this.repositoryName=repositoryName;
    }

    public Repository(String repositoryName, ArrayList<String> columnNames )
    {
        this.repositoryName=repositoryName;
        this.columnNames = columnNames;
    }

    public String getName()
    {
        return this.repositoryName;
    }

    public void setName(String repositoryName)
    {
        this.repositoryName=repositoryName;
    }

    public String getTableName()
    {
        return tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName=tableName;
    }

    public ArrayList<String> getColumnNames()
    {
        return columnNames;
    }

    public void setColumnNames(ArrayList<String> columnNames)
    {
        this.columnNames=columnNames;
    }

    //abstract public Entity getById(int entityId);

    public Repository setConnection(Connection connection)
    {
        this.connection=connection;
        return this;
    }

    public Repository setEntityManager(EntityManager entityManager )
    {
        this.entityManager = entityManager;
        return this;
    }

    public EntityManager getEntityManager()
    {
        return entityManager;
    }
}
