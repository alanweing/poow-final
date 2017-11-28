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
        <h1>Users</h1>
    </div>
    <c:forEach items="${users}" var="user">
        <div class="card">
            <div class="card-content">
                <a href="/user/${user.id}"><span class="card-title activator blue-text text-darken-4">@${user.login}
                </span></a>
                <p class="grey-text">Member since: ${user.createdAt}</p>
            </div>
            <div class="card-action">
                <c:choose>
                    <c:when test="${(me.id != user.id) && me.follows(user)}">
                        <a class="icon" href="/user/${user.id}/unfollow"><i class="material-icons">person_outline</i></a>
                    </c:when>
                    <c:when test="${(me.id != user.id && !me.follows(user))}">
                        <a class="icon" href="/user/${user.id}/follow"><i class="material-icons">person_add</i></a>
                    </c:when>
                </c:choose>
            </div>

        </div>
    </c:forEach>
</div>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/materialize.min.js"></script>
</body>

</html>