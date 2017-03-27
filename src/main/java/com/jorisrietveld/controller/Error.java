package com.jorisrietveld.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created on: 27-03-2017 12:30
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
        name="Error handler",
        description="This servlet gets called when an uncaught exception was thrown.",
        urlPatterns={"/error/fatal"}
)
public class Error extends HttpServlet
{
    protected Error()
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // Analyze the servlet exception
        Exception exception=(Exception) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode=(Integer) request.getAttribute("javax.servlet.error.status_code");
        String servletName=(String) request.getAttribute("javax.servlet.error.servlet_name");
        String requestUri=(String) request.getAttribute("javax.servlet.error.request_uri");

        // Set response content type
        response.setContentType("text/html");

        // print the output
        PrintWriter responseWriter=response.getWriter();
        responseWriter.write("<html><head><title>Something went wrong</title></head><body>");
        if(statusCode != 500)
        {
            responseWriter.write("<h3>Servlet 3 Exception Handling</h3>");
            responseWriter.write("<strong>Status Code</strong>:" + statusCode + "<br>");
            responseWriter.write("<strong>Requested URI</strong>:" + requestUri);
        }
        else
        {
            responseWriter.write("<h3>Servlet 3 Exception Handling</h3>");
            responseWriter.write("<ul><li>Servlet Name:" + servletName + "</li>");
            responseWriter.write("<li>Exception Name:" + exception.getClass().getName() + "</li>");
            responseWriter.write("<li>Requested URI:" + requestUri + "</li>");
            responseWriter.write("<li>Exception Message:" + exception.getMessage() + "</li>");
            responseWriter.write("</ul>");
        }
        responseWriter.write("</body></html>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        doGet(req, resp);
    }

}
