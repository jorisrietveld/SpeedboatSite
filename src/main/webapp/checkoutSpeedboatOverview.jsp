<%@ page import="jorisrietveld.model.SpeedBoat" %>
<%@ page import="jorisrietveld.model.EntityManager" %><%--
 = Author: Joris Rietveld <jorisrietveld@gmail.com>
 = Created on: 20-03-2017 12:35
 = Licence: GPLv3 - General public licence version 3.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>checkout speedboat overview</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<jsp:include page="authorized_navigation.jsp"/>
<main class="container">
    <section class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <h2>Checkout Speedboat overview</h2>
        <hr>
        <table class="table">
            <thead>
            <tr>
                <th>Number</th>
                <th>Weight</th>
                <th>Length</th>
                <th>Horse Power</th>
                <th>Rent Price</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <% for(SpeedBoat speedboat :
                            SpeedBoat)
                    {
                        
                    } %>
                </tr>
            </tbody>
        </table>
    </section>
</main>
</body>
</html>

