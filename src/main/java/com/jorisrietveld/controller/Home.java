package com.jorisrietveld.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 27-03-2017 12:17
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
@WebServlet(
        name="HomeAction",
        description="Route for welcoming a user on the website",
        urlPatterns={"/home", ""}
)
public class Home extends BaseController
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setAttribute("name", "Joris Rietveld");
        request.getRequestDispatcher( "/WEB-INF/home.jsp").forward( request, response );
    }
}
