package com.jorisrietveld.controller;

import com.jorisrietveld.controller.Actions.HomeAction;
import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletRequest;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 26-03-2017 18:40
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
public class ActionFactory
{
    protected HashMap<String,String[][]> config = new HashMap<String, String[][]>(){{
            put("HomeAction", new String[][]{
                    { "http-method", "POST", "GET" },
                    { "url", "/"}
            } );
    }};

    public static Action getAction(ServletRequest request)
    {
        return new HomeAction();
    }
}
