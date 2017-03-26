<%--
 = Author: Joris Rietveld <jorisrietveld@gmail.com>
 = Created on: 18-03-2017 18:51
 = Licence: GPLv3 - General public licence version 3.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Speedboat rental titanic</title>
    <jsp:include page="head.jsp" />
</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top">

    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                <span class="icon-bar"></span>
            </button>
        </div>

        <div class="navbar-collapse collapse" id="navbar-main">
            <ul class="nav navbar-nav navbar-right">

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="menu-login-form">
                        Aanmelden<span class="caret"></span>
                    </a>
                    <div class="dropdown-menu" style="padding:17px;">
                        <form class="form" id="menu-login-form" action="/login" method="post">
                            <input name="email" id="menu-login-form-email" placeholder="Email adres" type="email" class="" required/>
                            <input name="password" id="menu-login-form-password" placeholder="Wachtwoord" type="password" class="" required/>
                            <input name="Aanmelden" type="submit" id="menu-form-submit" value="Aanmelden" class="btn btn-info"/>
                        </form>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>

<main class="container">
    <section class="jumbotron row">
        <h1>${name}</h1>
        <h2 class="col-lg-12 col-md-12 col-sm-12 col-xs-12">Welcome at speedboat rental titanic</h2>
        <p class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            Titanic is one of the leading companies in speedboat rental in the arctic region. It has some of the best unsinkable
            speedboats that are iceberg proof so you don't need any lifeboats or life jackets. With Titanic &trade; you are
            guaranteed to have a life changing trip.
        </p>
        <img class="col-lg-10 col-md-10 col-sm-10 col-xs-10 offset-lg-1 offset-md-1 offset-sm-1 offset-xs-1" src="../resources/images/logo_text.png" alt="Titanic logo with text"/>
    </section>
</main>

<div id="authentication-error-modal" class="modal modal-lg" aria-hidden aria-labelledby="#authentication-model">
    <div class="modal-header">
        <h2>Authentication error</h2>
    </div>
    <div class="modal-body">
        <h4>The username and password combination is not found in our database, please try again</h4>
        <form class="form" id="login-form" action="/login" method="post">
            <input name="email" id="login-form-email" placeholder="Email adres" type="email" class=""/>
            <input name="password" id="login-form-password" placeholder="Wachtwoord" type="password" class=""/>
            <input name="login" type="submit" id="form-submit" value="Aanmelden" class="btn btn-info"/>
        </form>
    </div>
    <div class="modal-footer">
        <button type="button" class="pull-right btn btn-info">Close window</button>
    </div>
</div>

</body>
</html>
