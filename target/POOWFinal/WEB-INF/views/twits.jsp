
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X;-UA-Compatible" content="ie=edge">
    <title>POOW Final</title>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lobster+Two:400i" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/materialize.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/master.css" type="text/css">
</head>

<body>
<div class="navbar-fixed">
    <nav>
        <div class="nav-wrapper aw-navbar z-depth-3">
            <a href="#!" class="brand-logo center aw-nav-text">DefinitelyNotTwitter</a>
            <!-- <div class="center brand-logo">
                    <img class="aw-logo-img" src="img/twitter.svg">
                    <a href="#" class="">NotTwitter</a>
            </div> -->

            <ul id="nav-mobile" class="left hide-on-med-and-down">
                <li>
                    <a href="sass.html">Sass</a>
                </li>
                <li>
                    <a href="badges.html">Components</a>
                </li>
                <li>
                    <a href="collapsible.html">JavaScript</a>
                </li>
            </ul>
            <ul class="right hide-on-med-and-down">
                <li>
                    <a href="sass.html">
                        <i class="material-icons left">search</i>Link with Left Icon</a>
                </li>
                <li>
                    <a href="badges.html">
                        <i class="material-icons right">view_module</i>Link with Right Icon</a>
                </li>
            </ul>
        </div>
    </nav>
</div>

<br/>
<br/>

<div class="container">

    <div class="card">
        <%--<div class="card-image waves-effect waves-block waves-light">--%>
        <%--<img class="activator" src="images/office.jpg">--%>
        <%--</div>--%>
        <div class="card-content">
                <span class="card-title activator grey-text text-darken-4">Card Title
                    <i class="material-icons right">more_vert</i>
                </span>
            <p>
                <a href="#">This is a link</a>
            </p>
        </div>
        <div class="card-reveal">
                <span class="card-title grey-text text-darken-4">Card Title
                    <i class="material-icons right">close</i>
                </span>
            <p>Here is some more information about this product that is only revealed once clicked on.</p>
        </div>
    </div>

</div>

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/materialize.min.js"></script>
</body>

</html>