<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <style>
        <%@include file="../css/style.css" %>
        <%@include file="../css/w3.css" %>
    </style>
</head>
<body>
<%@include file="../elements/header.jsp" %>
<img src="/images/grupa.jpg" alt="Logo" style="width:100%">

<div class="w3-container w3-blue">
    <h1 align="center">Strona administratora</h1>
</div>

<br><br>

<div align="center">
    <a href="/company/all" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Firmy</a>
    <a href="/user/all" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Osoby</a>
    <a href="/contract/all" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Umowy</a>
    <hr>
    <a href="/mainCover/all" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Umowy główne</a>
    <a href="/rider/all" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Umowy dodatkowe</a>
    <a href="/product/all" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Produkty</a>
    <a href="/group/all" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Grupy</a>
    <hr>
    <a href="/admin/all" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Zmiana uprawnień</a>
    <a href="/admin/logout" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge" onclick="return confirm
            ('Na pewno chcesz się wylogować ?')">Wylogowanie</a>
    <hr>

</div>

</body>
</html>
