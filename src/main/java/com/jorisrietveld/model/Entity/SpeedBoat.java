package com.jorisrietveld.model.Entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 18-03-2017 11:13
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
public class SpeedBoat extends Entity implements EntityContract
{
    private int weight;
    private int horsePower;
    private int boatNumber;
    private int length;
    private BigDecimal rent;
    private Timestamp dateAdded;
    private Timestamp dateModified;

    /**
     * Speedboat simple constructor for initiating an empty speedboat object.
     */
    public SpeedBoat()
    {
    }

    /**
     * Speeboat constructor for initiating the an new speedboat object.
     * @param id
     * @param weight
     * @param horsePower
     * @param boatNumber
     * @param length
     * @param rent
     * @param dateAdded
     * @param dateModified
     */
    public SpeedBoat(int id, int weight, int horsePower, int boatNumber, int length, BigDecimal rent, Timestamp dateAdded, Timestamp dateModified )
    {
        this.id=id;
        this.weight=weight;
        this.horsePower=horsePower;
        this.boatNumber=boatNumber;
        this.length=length;
        this.rent=rent;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
        this.empty = false;
    }

    /**
     * Gets the value of the property speedBoatId
     *
     * @return speedBoatId int
     */
    public int getId()
    {
        return id;
    }

    /**
     * Sets the value of the speedBoatId property.
     *
     * @param id int
     */
    public void setId(int id)
    {
        this.id=id;
    }

    /**
     * Gets the value of the property weight
     *
     * @return weight int
     */
    public int getWeight()
    {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     *
     * @param weight int
     */
    public void setWeight(int weight)
    {
        this.weight=weight;
    }

    /**
     * Gets the value of the property horsePower
     *
     * @return horsePower int
     */
    public int getHorsePower()
    {
        return horsePower;
    }

    /**
     * Sets the value of the horsePower property.
     *
     * @param horsePower int
     */
    public void setHorsePower(int horsePower)
    {
        this.horsePower=horsePower;
    }

    /**
     * Gets the value of the property boatNumber
     *
     * @return boatNumber int
     */
    public int getBoatNumber()
    {
        return boatNumber;
    }

    /**
     * Sets the value of the boatNumber property.
     *
     * @param boatNumber int
     */
    public void setBoatNumber(int boatNumber)
    {
        this.boatNumber=boatNumber;
    }

    /**
     * Gets the value of the property length
     *
     * @return length int
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Sets the value of the length property.
     *
     * @param length int
     */
    public void setLength(int length)
    {
        this.length=length;
    }

    /**
     * Gets the value of the property rent
     *
     * @return rent java.math.BigDecimal
     */
    public BigDecimal getRent()
    {
        return rent;
    }

    /**
     * Sets the value of the rent property.
     *
     * @param rent java.math.BigDecimal
     */
    public void setRent(BigDecimal rent)
    {
        this.rent=rent;
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
     * Check if it is an real speedboat or an empty object.
     * @return empty boolean
     */
    public boolean isEmpty()
    {
        return empty;
    }
}
