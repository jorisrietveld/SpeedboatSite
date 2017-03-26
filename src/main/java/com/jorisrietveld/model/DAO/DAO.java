package com.jorisrietveld.model.DAO;

import java.sql.Connection;
import java.util.ArrayList;

import com.jorisrietveld.model.Entity.Entity;
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

    private Name repositoryName;
    private String tableName;
    private TableColumns columnNames;
    protected Connection connection;
    private EntityManager entityManager;

    public enum Name
    {
        CUSTOMER("Customer"),
        DAMAGE_REPORT("Damage Report"),
        RENTAL("Rental"),
        USER("User"),
        SPEEDBOAT("Speedboat");
        private String displayName;

        Name(String displayName)
        {
            this.displayName=displayName;
        }

        public String getDisplayName()
        {
            return this.displayName;
        }
    }

    public DAO(Name repositoryName)
    {
        this.repositoryName=repositoryName;
    }

    public DAO(Name repositoryName, String[] columnNames)
    {
        this.repositoryName=repositoryName;
        this.columnNames=columnNames;
    }

    public Name getName()
    {
        return this.repositoryName;
    }

    public void setName(Name repositoryName)
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

    abstract public Entity getById(int entityId);

    public DAO setConnection(Connection connection)
    {
        this.connection=connection;
        return this;
    }

    public DAO setEntityManager(EntityManager entityManager)
    {
        this.entityManager=entityManager;
        return this;
    }

    public EntityManager getEntityManager()
    {
        return entityManager;
    }
}
