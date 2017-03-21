package com.jorisrietveld.model.entity;

import java.util.ArrayList;
import java.util.Date;

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
public class RentedSpeedboat
{
    private int rentedSpeadBoatId;
    private SpeedBoat speedBoat;
    private Date onsetRental;
    private Date endRental;
    private int litersOfFuel;
    private ArrayList<DamageReport> damageReports;
    private boolean isRented;

    public RentedSpeedboat(int rentedSpeadBoatId, SpeedBoat speedBoat, Date onsetRental, Date endRental, int litersOfFuel, ArrayList<DamageReport> damageReports, boolean isRented )
    {
        this.rentedSpeadBoatId=rentedSpeadBoatId;
        this.speedBoat=speedBoat;
        this.onsetRental=onsetRental;
        this.endRental=endRental;
        this.litersOfFuel=litersOfFuel;
        this.damageReports=damageReports;
        this.isRented=isRented;
    }

    public int getRentedSpeadBoatId()
    {
        return rentedSpeadBoatId;
    }

    public void setRentedSpeadBoatId(int rentedSpeadBoatId)
    {
        this.rentedSpeadBoatId=rentedSpeadBoatId;
    }

    public SpeedBoat getSpeedBoat()
    {
        return speedBoat;
    }

    public void setSpeedBoat(SpeedBoat speedBoat)
    {
        this.speedBoat=speedBoat;
    }

    public Date getOnsetRental()
    {
        return onsetRental;
    }

    public void setOnsetRental(Date onsetRental)
    {
        this.onsetRental=onsetRental;
    }

    public Date getEndRental()
    {
        return endRental;
    }

    public void setEndRental(Date endRental)
    {
        this.endRental=endRental;
    }

    public int getLitersOfFuel()
    {
        return litersOfFuel;
    }

    public void setLitersOfFuel(int litersOfFuel)
    {
        this.litersOfFuel=litersOfFuel;
    }

    public ArrayList<DamageReport> getDamageReports()
    {
        return damageReports;
    }

    public void setDamageReports(ArrayList<DamageReport> damageReports)
    {
        this.damageReports=damageReports;
    }

    public boolean isRented()
    {
        return isRented;
    }

    public void setRented(boolean rented)
    {
        isRented=rented;
    }
}
