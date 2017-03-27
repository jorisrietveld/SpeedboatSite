package com.jorisrietveld.controller;

import com.jorisrietveld.exception.UnrecoverableWebApplicationException;
import com.jorisrietveld.model.EntityManager;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 27-03-2017 12:25
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
abstract class BaseController extends HttpServlet
{
    private EntityManager entityManager;

    public BaseController()
    {
        initBaseController();
    }

    public BaseController( boolean saveMode )
    {
        if( saveMode )
        {
            initBaseController();
        }
    }

    public void initBaseController(  )
    {
        this.entityManager = new EntityManager();
    }

    public EntityManager getEntityManager()
    {
        if( entityManager == null )
        {
            initBaseController();
        }
        return entityManager;
    }

    public String createJsonResponse(  )
    {

    }


}
