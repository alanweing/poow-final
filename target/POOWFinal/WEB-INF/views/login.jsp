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
        </div>
    </nav>
</div>
<br>
<br>
<div class="container">
    <div class="row">
        <h1>Sign-in</h1>
    </div>
    <div class="row">
        <form:form action="login" modelAttribute="user" cssClass="col s12" method="post">
            <div class="row">
                <div class="input-field col s12 black-text">
                    <form:input path="login" id="login" cssClass="validate" />
                    <label for="login">Login</label>
                </div>
                <form:errors cssStyle="color:red" path="login" element="div" cssClass="col s12"/>
            </div>
            <div class="row">
                <div class="input-field col s12 black-text">
                    <form:password path="password" id="password" cssClass="validate"/>
                    <label for="password">Password</label>
                </div>
                <form:errors cssStyle="color:red" path="password" element="div" cssClass="col s12"/>
            </div>
            <c:if test="${error != null}">
                <div class="row">
                    <div class="col s12" style="color:red">
                        <p>${error}</p>
                    </div>
                </div>
            </c:if>
            <div class="row">
                <button class="btn waves-effect waves-light" type="submit">sign in
                    <i class="material-icons right">send</i>
                </button>
                <a class="btn waves-effect waves-light" type="button" href="user/create">sign up
                    <i class="material-icons right">person add</i>
                </a>
            </div>
        </form:form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/materialize.min.js"></script>
</body>

</html>