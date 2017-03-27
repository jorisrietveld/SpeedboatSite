package com.jorisrietveld.controller;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 27-03-2017 14:23
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
        name="Login",
        description="The controller for authentication",
        urlPatterns = { "/login" }
)
public class Login extends HttpServlet
{
    private short errorCount = 0;
    private ArrayList<String> errorMessages;

    public Login()
    {
        super();
        errorMessages = new ArrayList<String>();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getAttribute( "username" ) != null ? (String)request.getAttribute("username") : "";
        String password = request.getAttribute( "password" ) != null ? (String)request.getAttribute("password") : "";

        response.setContentType("application/json");
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        if( username.length() < 1 )
        {
            errorMessages.add("You must fill in your username.");
            errorCount++;
        }

        if( password.length() < 1 )
        {
            errorMessages.add("You must fill in your password.");
            errorCount++;
        }

        if( username.length() < 1 || password.length() < 1 )
        {
            PrintWriter responseWriter = response.getWriter();

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.sendError( 500 );
    }
}

/**
 *
 */