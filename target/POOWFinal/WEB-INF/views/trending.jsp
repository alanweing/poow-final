<%@ page import="me.alanwe.poowfinal.models.Like" %>
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

<div class="fixed-action-btn">
    <a class="btn-floating btn-large red" href="twit/create">
        <i class="large material-icons">create</i>
    </a>
</div>

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
                    <a href="/twit">
                        <i class="material-icons">public</i>
                    </a>
                </li>
                <li>
                    <a href="/user">
                        <i class="material-icons">face</i>
                    </a>
                </li>
                <li>
                    <a href="/twit/trending">
                        <i class="material-icons">whatshot</i>
                    </a>
                </li>
                <li>
                    <a href="/twit/mine">
                        <i class="material-icons">archive</i>
                    </a>
                </li>
            </ul>
            <ul class="right hide-on-med-and-down">
                <li>
                    <a href="user/logout">
                        <i class="material-icons">exit_to_app</i>@${user.login}
                    </a>
                </li>
            </ul>
        </div>
    </nav>
</div>

<br/>
<br/>

<div class="container">

    <c:forEach items="${twits}" var="twit">
        <div class="card">
            <div class="card-content">
                <a href="/user/${twit.user.id}"><span class="card-title activator blue-text text-darken-4">@${twit.user.login}
                </span></a>
                <p class="flow-text">${twit.message}</p>
                <br>
                <p class="grey-text">Last modified: ${twit.updatedAt}</p>
            </div>
            <div class="card-action">
                <c:choose>
                    <c:when test="${twit.user.id == user.id}">
                        <a class="icon"><i class="material-icons">favorite_border</i>${twit.likes.size()}</a>
                        <a href="/twit/${twit.id}/update"><i class="material-icons">mode_edit</i></a>
                        <a href="/twit/${twit.id}/delete"><i class="material-icons">delete</i></a>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${twit.liked(user)}">
                                <a class="icon" href="/twit/${twit.id}/unlike"><i class="material-icons">favorite</i>${twit.likes.size()}</a>
                            </c:when>
                            <c:otherwise>
                                <a class="icon" href="/twit/${twit.id}/like"><i class="material-icons">favorite_border</i>${twit.likes.size()}</a>
                            </c:otherwise>
                        </c:choose>
                        <a href="/twit/${twit.id}/retwit"><i class="material-icons">share</i></a>
                    </c:otherwise>
                </c:choose>
            </div>

        </div>
    </c:forEach>


</div>

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/materialize.min.js"></script>
</body>

</html>