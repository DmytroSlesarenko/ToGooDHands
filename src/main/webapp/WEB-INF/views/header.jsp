<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>To GooD HandS</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li class="logged-user">
                ${user.firstName} ${user.lastName}
                <ul class="dropdown">
                    <li><a href="#">Profil</a></li>
                    <li><a href="#">Moje zbiórki</a></li>
                    <li><a href="/logout">Wyloguj</a></li>
                </ul>
            </li>
        </ul>

        <ul>
            <li><a href="/donation" class="btn btn--without-border active">Start</a></li>
            <li><a href="/donation#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="/donation#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="/donation#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="/add" class="btn btn--without-border">Przekaż dary</a></li>
            <li><a href="/donation#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>