package com.jorisrietveld.model.entity;

import java.sql.Timestamp;

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
public interface Entity
{
    public int getId();
    public boolean isEmpty();
    public Timestamp getDateAdded();
    public Timestamp getDateModified();
}
