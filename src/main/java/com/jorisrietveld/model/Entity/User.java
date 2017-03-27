package com.jorisrietveld.model.Entity;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 18-03-2017 19:00
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
public class User extends Entity implements EntityContract
{
    private String username;
    private String password;
    private Timestamp dateAdded;
    private Timestamp dateModified;

    /**
     * Simple user constructor for creating an empty user object.
     */
    public User()
    {
    }

    /**
     * User constructor for creating an user object.
     * @param id
     * @param username
     * @param password
     * @param dateAdded
     * @param dateModified
     */
    public User(int id, String username, String password, Timestamp dateAdded, Timestamp dateModified )
    {
        this.id = id;
        this.username=username;
        this.password=password;
        this.dateAdded= dateAdded;
        this.dateModified=dateModified;
    }

    /**
     * Gets the value of the property id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param id int
     */
    public void setId(int id)
    {
        this.id=id;
    }

    /**
     * Gets the value of the property username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Sets the value of the username property.
     *
     * @param username java.lang.String
     */
    public void setUsername(String username)
    {
        this.username=username;
    }

    /**
     * Gets the value of the property password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param password java.lang.String
     */
    public void setPassword(String password)
    {
        this.password=password;
    }

    /**
     * Gets the value of the property dateAdded
     */
    public Timestamp getDateAdded()
    {
        return dateAdded;
    }

    /**
     * Gets the value of the property dateModified
     */
    public Timestamp getDateModified()
    {
        return dateModified;
    }

    /**
     * Check if it is an real user or an empty object.
     * @return empty boolean
     */
    public boolean isEmpty()
    {
        return empty;
    }
}
