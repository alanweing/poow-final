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
    <h1>@${user.login}</h1>
    <p class="grey-text">Member since: ${user.createdAt}</p>
    <br>
    <c:forEach items="${twits}" var="twit">
        <div class="card">
            <div class="card-content">
                <p class="flow-text">${twit.message}</p>
                <br>
                <p class="grey-text">${twit.updatedAt}</p>
            </div>
        </div>
    </c:forEach>
</div>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/materialize.min.js"></script>
</body>

</html>