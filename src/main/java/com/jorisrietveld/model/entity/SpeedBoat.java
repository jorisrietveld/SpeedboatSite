package com.jorisrietveld.model.entity;

import java.util.ArrayList;

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
public class SpeedBoat implements Entity
{
    private int speedBoatId;
    private int weight;
    private int horsePower;
    private int boatNumber;
    private int length;
    private int rent;
    private ArrayList<DamageReport> damageReports;

    public SpeedBoat(int speedBoatId, int weight, int horsePower, int boatNumber, int length, int rent, ArrayList<DamageReport> damageReports)
    {
        this.speedBoatId=speedBoatId;
        this.weight=weight;
        this.horsePower=horsePower;
        this.boatNumber=boatNumber;
        this.length=length;
        this.rent=rent;
        this.damageReports=damageReports;
    }

    public SpeedBoat()
    {
    }

    public int getSpeedBoatId()
    {
        return speedBoatId;
    }

    public void setSpeedBoatId(int speedBoatId)
    {
        this.speedBoatId=speedBoatId;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight=weight;
    }

    public int getHorsePower()
    {
        return horsePower;
    }

    public void setHorsePower(int horsePower)
    {
        this.horsePower=horsePower;
    }

    public int getBoatNumber()
    {
        return boatNumber;
    }

    public void setBoatNumber(int boatNumber)
    {
        this.boatNumber=boatNumber;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length=length;
    }

    public int getRent()
    {
        return rent;
    }

    public void setRent(int rent)
    {
        this.rent=rent;
    }

    public ArrayList<DamageReport> getDamageReports()
    {
        return damageReports;
    }

    public void setDamageReports(ArrayList<DamageReport> damageReports)
    {
        this.damageReports=damageReports;
    }
}
