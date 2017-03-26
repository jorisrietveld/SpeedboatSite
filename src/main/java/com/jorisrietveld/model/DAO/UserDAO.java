package com.jorisrietveld.model.DAO;

import com.jorisrietveld.model.Entity.Entity;
import com.jorisrietveld.model.Entity.User;

import java.util.ArrayList;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 22-03-2017 11:45
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
public class UserDAO extends DAO
{
    public static final String TABLE_NAME = "User";
    public static final ArrayList<String> TABLE_COLUMNS = new ArrayList<String>() {{
        add("id");
        add("username");
        add("password");
        add("dateAdded");
        add("dateModified");
    }};

    public UserDAO()
    {
        super( Name.USER, TABLE_COLUMNS );
    }

    @Override
    public Entity getById(int entityId)
    {
        return null;
    }

    public User getByUsername( String username )
    {
        return new User();
    }
}
