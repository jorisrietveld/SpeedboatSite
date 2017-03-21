<%--
 = Author: Joris Rietveld <jorisrietveld@gmail.com>
 = Created on: 18-03-2017 18:51
 = Licence: GPLv3 - General public licence version 3.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Speedboat rental titanic</title>
    <jsp:include page="head.jsp" />
</head>
<body>
<h1>Login</h1>
<form action="LoginController" method="post">
    Enter username : <input type="text" name="username"> <BR>
    Enter password : <input type="password" name="password"> <BR>
    <input type="submit" />
</form>
</body>
</html>