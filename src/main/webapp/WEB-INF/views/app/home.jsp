<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <style>
        <%@include file="css/style.css" %>
        <%@include file="css/w3.css" %>
    </style>
</head>
<body>
<%@include file="/WEB-INF/views/app/elements/header.jsp" %>

<img src="images/grupa.jpg" alt="Logo" style="width:100%">
<div class="w3-container w3-blue">
    <h1 align="center">Logowanie</h1>
</div>
<hr>

<c:if test="${error==1}">
    <div class="w3-panel w3-red w3-display-container">
        <span onclick="this.parentElement.style.display='none';
            <c:set var="error" value="0" scope="session" />"
              class="w3-button w3-large w3-display-topright">&times;</span>
        <p> Podałeś niepoprawny login lub hasło !</p>
    </div>
</c:if>

<c:if test="${passwordChanged==true}">
    <div class="w3-panel w3-red w3-display-container">
        <span onclick="this.parentElement.style.display='none';
            <c:set var="passwordChanged" value="0" scope="session" />"
              class="w3-button w3-large w3-display-topright">&times;</span>
        <p> Hasło zostało zmienione...</p>
    </div>
</c:if>

<c:if test="${error==3}">
    <div class="w3-panel w3-red w3-display-container">
        <span onclick="this.parentElement.style.display='none';
            <c:set var="error" value="0" scope="session" />"
              class="w3-button w3-large w3-display-topright">&times;</span>
        <p> Wylogowano z systemu...</p>
    </div>
</c:if>


<div align="center">
    <form method="post">
        <input type="text" name="pesel" placeholder="podaj PESEL" class=w3-xlarge>
        <input type="password" name="password" placeholder="podaj hasło" class=w3-xlarge><br><br>
        <button type="submit" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Zaloguj</button>
    </form>
</div>
</body>
</html>
