package com.jorisrietveld.controller.Actions;

import com.jorisrietveld.controller.Action;
import com.jorisrietveld.exception.ActionException;
import com.jorisrietveld.model.DAO.DAO;
import com.jorisrietveld.model.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 26-03-2017 16:14
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
@WebServlet(name="HomeAction", urlPatterns = "/", description = "Route for welcoming a user on the website")
public class HomeAction extends Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ActionException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = entityManager.find( DAO.ENTITY_NAME.USER ).getBy(  );

        if (user != null) {
            request.getSession().setAttribute("user", user); // Login user.
            return "home"; // Redirect to home page.
        }
        else {
            request.setAttribute("error", "Unknown username/password. Please retry."); // Store error message in request scope.
            return "login"; // Go back to redisplay login form with error.
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setAttribute("name", "Joris Rietveld");
        request.getRequestDispatcher( "/WEB-INF/home.jsp").forward( request, response );
    }
}
