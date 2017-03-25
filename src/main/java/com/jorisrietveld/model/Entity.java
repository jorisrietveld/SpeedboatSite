package com.jorisrietveld.model;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 20-03-2017 15:26
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
public abstract class Entity
{
    protected boolean empty = true;
    protected int id;
    protected Timestamp dateAdded;
    protected Timestamp dateModified;
    protected String tableName;
    protected ArrayList<String> columnNames;

    public Entity()
    {
    }

    public Entity( String tableName, ArrayList<String> columnNames )
    {
        this.tableName = tableName;
        this.columnNames = columnNames;
    }

    public int getId()
    {
        return this.id;
    }

    public boolean isEmpty()
    {
        return this.empty;
    }
    public Timestamp getDateAdded()
    {
        return dateAdded;
    }

    public Timestamp getDateModified()
    {
        return dateModified;
    }
}
