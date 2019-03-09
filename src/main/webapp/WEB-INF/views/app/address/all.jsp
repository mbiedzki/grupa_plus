<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        <%@include file="../css/style.css"%>
        <%@include file="../css/w3.css" %>
    </style>
    <title>Adresy</title>
</head>
<%@include file="../elements/header.jsp" %>
<body>
<h1>Adresy w bazie danych</h1>
<table class="w3-table-all">
    <thead>
    <tr class="w3-blue">
        <td>Ulica</td>
        <td>Nr domu</td>
        <td>Nr mieszkania</td>
        <td>Kod</td>
        <td>Miasto</td>
        <td>Edycja</td>
        <td>Usuwanie</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${addresses}" var="address">
        <tr>
            <td>${address.street}</td>
            <td>${address.number}</td>
            <td>${address.apartment}</td>
            <td>${address.zip}</td>
            <td>${address.city}</td>
            <td><a href="${pageContext.request.contextPath}/address/edit/${address.id}">Edytuj adres</a></td>
            <td><a href="${pageContext.request.contextPath}/address/delete/${address.id}" onclick="return confirm
            ('Na pewno chcesz usunąć ?')">Usuń adres</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="${pageContext.request.contextPath}/address/add" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Nowy adres</a>
<a href="${pageContext.request.contextPath}/admin/adminHome" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Panel administratora</a>
</body>
</html>
