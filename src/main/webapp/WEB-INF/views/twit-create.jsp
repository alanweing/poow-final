<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <ul id="nav-mobile" class="left hide-on-med-and-down">
                <li>
                    <a href="/twit">
                        <i class="material-icons">arrow_back</i>
                    </a>
                </li>
            </ul>
        </div>
    </nav>
</div>
<br>
<br>
<div class="container">
    <div class="row">
        <form:form action="/twit/create" modelAttribute="twit" cssClass="col s12" method="post">
            <form:hidden path="id"/>
            <div class="row">
                <div class="input-field col s12">
                    <form:textarea path="message" id="message" cssClass="materialize-textarea"/>
                    <label for="message">Message</label>
                </div>
            </div>
            <div class="row">
                <button class="btn waves-effect waves-light" type="submit">twit</button>
            </div>
            <form:errors path="message" cssStyle="color:red"/>
        </form:form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/materialize.min.js"></script>
</body>

</html>