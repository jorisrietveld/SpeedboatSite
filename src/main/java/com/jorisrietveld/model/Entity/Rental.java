package com.jorisrietveld.model.Entity;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 20-03-2017 15:33
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
public class Rental extends Entity
{
    private SpeedBoat speedBoat;
    private Customer customer;
    private int fuelLevelStart;
    private int fuelLevelEnd;
    private boolean currentlyRented;
    private Timestamp rentedStartDate;
    private Timestamp rentedEndDate;
    private ArrayList<DamageReport> damageReports;
    private Timestamp dateAdded;
    private Timestamp dateModified;

    /**
     * Simple rental constructor for initiating an empty rental object.
     */
    public Rental()
    {
    }

    /**
     * Rental constructor for initiating an rental object.
     *
     * @param id
     * @param speedBoat
     * @param customer
     * @param fuelLevelStart
     * @param fuelLevelEnd
     * @param currentlyRented
     * @param rentedStartDate
     * @param rentedEndDate ffffffffffffffffff
     * @param damageReports
     * @param dateAdded
     * @param dateModified
     */
    public Rental(int id, SpeedBoat speedBoat, Customer customer, int fuelLevelStart, int fuelLevelEnd, boolean currentlyRented, Timestamp rentedStartDate, Timestamp rentedEndDate, ArrayList<DamageReport> damageReports, Timestamp dateAdded, Timestamp dateModified)
    {
        this.id=id;
        this.speedBoat=speedBoat;
        this.customer=customer;
        this.fuelLevelStart=fuelLevelStart;
        this.fuelLevelEnd=fuelLevelEnd;
        this.currentlyRented=currentlyRented;
        this.rentedStartDate=rentedStartDate;
        this.rentedEndDate=rentedEndDate;
        this.damageReports=damageReports;
        this.dateAdded=dateAdded;
        this.dateModified=dateModified;
        this.empty = false;
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
     * Gets the value of the property speedBoat
     */
    public SpeedBoat getSpeedBoat()
    {
        return speedBoat;
    }

    /**
     * Sets the value of the speedBoat property.
     *
     * @param speedBoat com.jorisrietveld.model.EntityName.SpeedBoat
     */
    public void setSpeedBoat(SpeedBoat speedBoat)
    {
        this.speedBoat=speedBoat;
    }

    /**
     * Gets the value of the property customer
     */
    public Customer getCustomer()
    {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     *
     * @param customer com.jorisrietveld.model.EntityName.Customer
     */
    public void setCustomer(Customer customer)
    {
        this.customer=customer;
    }

    /**
     * Gets the value of the property fuelLevelStart
     */
    public int getFuelLevelStart()
    {
        return fuelLevelStart;
    }

    /**
     * Sets the value of the fuelLevelStart property.
     *
     * @param fuelLevelStart int
     */
    public void setFuelLevelStart(int fuelLevelStart)
    {
        this.fuelLevelStart=fuelLevelStart;
    }

    /**
     * Gets the value of the property fuelLevelEnd
     */
    public int getFuelLevelEnd()
    {
        return fuelLevelEnd;
    }

    /**
     * Sets the value of the fuelLevelEnd property.
     *
     * @param fuelLevelEnd int
     */
    public void setFuelLevelEnd(int fuelLevelEnd)
    {
        this.fuelLevelEnd=fuelLevelEnd;
    }

    /**
     * Gets the value of the property rentedStartDate
     */
    public Timestamp getRentedStartDate()
    {
        return rentedStartDate;
    }

    /**
     * Sets the value of the rentedStartDate property.
     *
     * @param rentedStartDate java.sql.timestamp
     */
    public void setRentedStartDate(Timestamp rentedStartDate)
    {
        this.rentedStartDate=rentedStartDate;
    }

    /**
     * Gets the value of the property rentedEndDate
     */
    public Timestamp getRentedEndDate()
    {
        return rentedEndDate;
    }

    /**
     * Sets the value of the rentedEndDate property.
     *
     * @param rentedEndDate java.sql.timestamp
     */
    public void setRentedEndDate(Timestamp rentedEndDate)
    {
        this.rentedEndDate=rentedEndDate;
    }

    /**
     * Gets the value of the property damageReports
     */
    public ArrayList<DamageReport> getDamageReports()
    {
        return damageReports;
    }

    /**
     * Sets the value of the damageReports property.
     *
     * @param damageReports java.util.ArrayList<com.jorisrietveld.model.EntityName.DamageReport>
     */
    public void setDamageReports(ArrayList<DamageReport> damageReports)
    {
        this.damageReports=damageReports;
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
    * Check if it is an real speedboat or an empty object.
    * @return empty boolean
    */
    public boolean isEmpty()
    {
        return empty;
    }

    /**
     * Gets the value of the property is currentlyRented.
     *
     * @return currentlyRented boolean
     */
    public boolean isCurrentlyRented()
    {
        return currentlyRented;
    }

    /**
     * Sets the value of the dateModified property.
     *
     * @param currentlyRented boolean
     */
    public void setCurrentlyRented(boolean currentlyRented)
    {
        this.currentlyRented=currentlyRented;
    }
}
