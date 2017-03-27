package com.jorisrietveld.controller;

import javax.jws.WebMethod;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 26-03-2017 18:18
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
@WebServlet(name="app", urlPatterns = "/*", description = "The sites front controller")
public class FrontController extends HttpServlet
{
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            Action action=ActionFactory.getAction(request);
            String view=action.execute(request, response);

            if(view.equals(request.getPathInfo().substring(1)))
            {
                request.getRequestDispatcher("/WEB-INF/" + view + ".jsp").forward(request, response);

            }
            else
            {
                response.sendRedirect(view); // We'd like to fire redirect in case of a view change as result of the action (PRG pattern).
            }
        }
        catch(Exception e)
        {
            throw new ServletException("Executing action failed.", e);
        }
    }
}
