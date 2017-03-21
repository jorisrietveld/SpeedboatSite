package com.jorisrietveld.model.entity;

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
public class DamageReport
{
    private int damageId;
    private String damageTitle;
    private String damageDescription;
    private String damageCost;

    public DamageReport(int damageId, String damageTitle, String damageDescription, String damageCost)
    {
        this.damageId=damageId;
        this.damageTitle=damageTitle;
        this.damageDescription=damageDescription;
        this.damageCost=damageCost;
    }

    public int getDamageid()
    {
        return damageId;
    }

    public void setDamageid(int damageId)
    {
        this.damageId=damageId;
    }

    public String getDamageTitle()
    {
        return damageTitle;
    }

    public void setDamageTitle(String damageTitle)
    {
        this.damageTitle=damageTitle;
    }

    public String getDamageDescription()
    {
        return damageDescription;
    }

    public void setDamageDescription(String damageDescription)
    {
        this.damageDescription=damageDescription;
    }

    public String getDamageCost()
    {
        return damageCost;
    }

    public void setDamageCost(String damageCost)
    {
        this.damageCost=damageCost;
    }
}
