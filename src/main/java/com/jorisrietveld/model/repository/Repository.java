package com.jorisrietveld.model.repository;

import java.sql.Connection;
import java.util.ArrayList;

import com.jorisrietveld.model.Entity;
import com.jorisrietveld.model.SpeedBoat;

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
    protected String repositoryName;
    protected String tableName;
    protected ArrayList<String> columnNames;
    protected Connection connection;

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

    public Entity getById(int entityId)
    {

        return new SpeedBoat();
    }

    public Repository setConnection(Connection connection)
    {
        this.connection=connection;
        return this;
    }
}
