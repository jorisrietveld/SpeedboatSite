<%--
 = Author: Joris Rietveld <jorisrietveld@gmail.com>
 = Created on: 20-03-2017 12:33
 = Licence: GPLv3 - General public licence version 3.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Speedboat overview</title>
    <jsp:include page="head.jsp"/>
</head>
<body>
<jsp:include page="authorized_navigation.jsp"/>
<main class="container">
    <section class="row col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <h2>Speedboat overview</h2>
        <hr>
        <% for(SpeedBoat speedBoat : speedBoats ) %>
    </section>
</main>
</body>
</html>
