package com.jorisrietveld.controller;

import com.jorisrietveld.exception.ActionException;
import com.jorisrietveld.model.EntityManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 26-03-2017 18:28
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
public abstract class Action
{
    protected EntityManager entityManager;
    protected HttpServletRequest request;
    protected HttpServletResponse response;

    public abstract String execute(HttpServletRequest request, HttpServletResponse response) throws ActionException;

    /**
     * Gets the value of the property entityManager
     */
    public EntityManager getEntityManager()
    {
        return entityManager;
    }

    /**
     * Sets the value of the entityManager property.
     *
     * @param entityManager com.jorisrietveld.model.EntityManager
     */
    public void setEntityManager(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }

    /**
     * Gets the value of the property request
     */
    public HttpServletRequest getRequest()
    {
        return request;
    }

    /**
     * Sets the value of the request property.
     *
     * @param request javax.servlet.http.HttpServletRequest
     */
    public void setRequest(HttpServletRequest request)
    {
        this.request=request;
    }

    /**
     * Gets the value of the property response
     */
    public HttpServletResponse getResponse()
    {
        return response;
    }

    /**
     * Sets the value of the response property.
     *
     * @param response javax.servlet.http.HttpServletResponse
     */
    public void setResponse(HttpServletResponse response)
    {
        this.response=response;
    }
}
