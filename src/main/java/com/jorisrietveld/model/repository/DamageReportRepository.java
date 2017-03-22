package com.jorisrietveld.model.repository;

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
public class DamageReportRepository extends Repository
{
    /**
     * Initiate the default table settings for the DamageReport Repo.
     */
    private static final String TABLE_NAME = "DamageReport";
    private static final ArrayList<String> TABLE_COLUMNS = new ArrayList<String>() {{
        add("id");
        add("rentalId");
        add("title");
        add("description");
        add("cost");
        add("dateAdded");
        add("dateModified");
    }};

    public DamageReportRepository()
    {
        super( "DamageReport" );
    }
}
