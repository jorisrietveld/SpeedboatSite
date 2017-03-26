package com.jorisrietveld.model.DAO;

import com.jorisrietveld.model.Entity.Entity;

import java.util.ArrayList;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 20-03-2017 15:09
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
public class SpeedboatDAO extends DAO
{
    private static final String TABLE_NAME = "Speedboat";
    private static final ArrayList<String> TABLE_COLUMNS = new ArrayList<String>() {{
        add("id");
        add("weight");
        add("horsePower");
        add("boatNumber");
        add("rent");
        add("dateAdded");
        add("dateModified");
    }};

    public SpeedboatDAO()
    {
        super(Name.SPEEDBOAT, TABLE_COLUMNS );
    }

    @Override
    public Entity getById(int entityId)
    {
        return null;
    }
}
