package com.jorisrietveld.model.Entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 18-03-2017 11:18
 * Licence: GPLv3 - General public licence version 3.
 * Teachers: Rob loves and  Winnie van Schilt
 *
 *======================================================================
 *===               Java final assignment number: 10                 ===
 *======================================================================
 *               An short description about the project
 *----------------------------------------------------------------------
 * An speedboat rental company wants to digitize there rental records.
 * The company owns 10 speedboats and they want to record what speedboat
 * get rented on what date, the amount of fuel that was used, the total
 * profit earned and the damage that the speedboat accumulated during
 * the speedboat rental.
 */
public class DamageReport extends Entity
{
    private Rental rental;
    private String title;
    private String description;
    private BigDecimal cost;
    private Timestamp dateAdded;
    private Timestamp dateModified;

    /**
     * Simple damage report constructor for initiating an empty damage report object.
     */
    public DamageReport()
    {
    }

    /**
     * Damage report constructor for creating an damage report object.
     *
     * @param id
     * @param rental
     * @param title
     * @param description
     * @param cost
     * @param dateAdded
     * @param dateModified
     */
    public DamageReport(int id, Rental rental, String title, String description, BigDecimal cost, Timestamp dateAdded, Timestamp dateModified)
    {
        this.id=id;
        this.rental=rental;
        this.title=title;
        this.description=description;
        this.cost=cost;
        this.dateAdded=dateAdded;
        this.dateModified=dateModified;
        this.empty=false;
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
     * Gets the value of the property rental
     */
    public Rental getRental()
    {
        return rental;
    }

    /**
     * Sets the value of the rental property.
     *
     * @param rental com.jorisrietveld.model.EntityName.Rental
     */
    public void setRental(Rental rental)
    {
        this.rental=rental;
    }

    /**
     * Gets the value of the property title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Sets the value of the title property.
     *
     * @param title java.lang.String
     */
    public void setTitle(String title)
    {
        this.title=title;
    }

    /**
     * Gets the value of the property description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param description java.lang.String
     */
    public void setDescription(String description)
    {
        this.description=description;
    }

    /**
     * Gets the value of the property cost
     */
    public BigDecimal getCost()
    {
        return cost;
    }

    /**
     * Sets the value of the cost property.
     *
     * @param cost java.math.BigDecimal
     */
    public void BigDecimal(BigDecimal cost)
    {
        this.cost=cost;
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
     * Check if it is an real damage report or an empty object.
     *
     * @return empty boolean
     */
    public boolean isEmpty()
    {
        return empty;
    }
}
