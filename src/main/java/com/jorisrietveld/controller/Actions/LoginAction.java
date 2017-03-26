package com.jorisrietveld.controller.Actions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 26-03-2017 17:53
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
@WebServlet(name="LoginAction", urlPatterns = "/login", description = "Route for welcoming a user on the website")
public class LoginAction extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
       response.setStatus(405);
       response.getWriter()
               .append("<html><head>")
               .append( "Error 405, this HTTP method is not allowed for the route: " )
               .append(getServletContext().getContextPath());
    }
}
