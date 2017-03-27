package com.jorisrietveld.exception;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 27-03-2017 12:46
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
public class UnrecoverableWebApplicationException extends Exception
{
    public UnrecoverableWebApplicationException()
    {
    }

    public UnrecoverableWebApplicationException(String s)
    {
        super(s);
    }

    public UnrecoverableWebApplicationException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public UnrecoverableWebApplicationException(Throwable throwable)
    {
        super(throwable);
    }

    public UnrecoverableWebApplicationException(String s, Throwable throwable, boolean b, boolean b1)
    {
        super(s, throwable, b, b1);
    }
}
