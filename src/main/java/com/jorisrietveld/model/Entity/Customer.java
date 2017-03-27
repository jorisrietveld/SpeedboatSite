package com.jorisrietveld.model.Entity;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 22-03-2017 09:24
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
public class Customer extends Entity implements EntityContract
{
    private String firstName;
    private String lastName;
    private String email;
    private String telephoneNumber;
    private Timestamp dateAdded;
    private Timestamp dateModified;

    /**
     * Customer simple constructor for creating empty customer objects.
     */
    public Customer()
    {
    }

    /**
     * Customer constructor for creating an new customer object.
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param email
     * @param telephoneNumber
     * @param dateAdded
     * @param dateModified
     */
    public Customer(int id, String firstName, String lastName, String email, String telephoneNumber, Timestamp dateAdded, Timestamp dateModified)
    {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.telephoneNumber=telephoneNumber;
        this.dateAdded=dateAdded;
        this.dateModified=dateModified;
        this.empty = false;
    }

    /**
     * Gets the value of the property id
     *
     * @return id int
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
     * Gets the value of the property firstName
     *
     * @return firstName java.lang.String
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     *
     * @param firstName java.lang.String
     */
    public void setFirstName(String firstName)
    {
        this.firstName=firstName;
    }

    /**
     * Gets the value of the property lastName
     *
     * @return lastName java.lang.String
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     *
     * @param lastName java.lang.String
     */
    public void setLastName(String lastName)
    {
        this.lastName=lastName;
    }

    /**
     * Gets the value of the property email
     *
     * @return email java.lang.String
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Sets the value of the email property.
     *
     * @param email java.lang.String
     */
    public void setEmail(String email)
    {
        this.email=email;
    }

    /**
     * Gets the value of the property telephoneNumber
     *
     * @return telephoneNumber java.lang.String
     */
    public String getTelephoneNumber()
    {
        return telephoneNumber;
    }

    /**
     * Sets the value of the telephoneNumber property.
     *
     * @param telephoneNumber java.lang.String
     */
    public void setTelephoneNumber(String telephoneNumber)
    {
        this.telephoneNumber=telephoneNumber;
    }

    /**
     * Gets the value of the property dateAdded
     *
     * @return dateAdded java.util.Date
     */
    public Timestamp getDateAdded()
    {
        return dateAdded;
    }

    /**
     * Gets the value of the property dateModified
     *
     * @return dateModified java.util.Date
     */
    public Timestamp getDateModified()
    {
        return dateModified;
    }

    /**
     * Check if it is an real customer or an empty object.
     * @return empty boolean
     */
    public boolean isEmpty()
    {
        return empty;
    }
}
