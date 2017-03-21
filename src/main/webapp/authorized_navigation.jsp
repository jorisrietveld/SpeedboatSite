<%--
 = Author: Joris Rietveld <jorisrietveld@gmail.com>
 = Created on: 20-03-2017 12:24
 = Licence: GPLv3 - General public licence version 3.
--%>
<div class="navbar navbar-default navbar-fixed-top">

    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="navbar-collapse collapse" id="navbar-main">
            <ul class="nav navbar-nav">
                <li>
                    <a class="">Home</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" id="login-form">
                        Aanmelden<span class="caret"></span>
                    </a>
                    <div class="dropdown-menu" style="padding:17px;">
                        <form class="form" id="login-form" action="/login" method="post">
                            <input name="email" id="login-form-email" placeholder="Email adres" type="email" class=""/>
                            <input name="password" id="login-form-password" placeholder="Wachtwoord" type="password" class=""/>
                            <input name="Aanmelden" type="submit" id="form-submit" value="Aanmelden" class="btn btn-info"/>
                        </form>
                    </div>
                </li>
            </ul>

        </div>
    </div>
</div>