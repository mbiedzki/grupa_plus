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
<h1>Osoby w bazie danych</h1>

<c:if test="${deleteError==true}">
    <div align="center" class="w3-xxlarge w3-panel w3-red">
        Nie można usunąć osoby, jest przypisana do umowy
    </div>
</c:if>

<table class="w3-table-all">
    <thead>
    <tr class="w3-blue">
        <td>Imię</td>
        <td>Nazwisko</td>
        <td>PESEL</td>
        <td>Telefon</td>
        <td>Email</td>
        <td>Edycja</td>
        <td>Usuwanie</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.pesel}</td>
            <td>${user.phone}</td>
            <td>${user.email}</td>
            <td><a href="/user/edit/${user.id}">Edytuj osobę</a></td>
            <td><a href="/user/delete/${user.id}" onclick="return confirm
            ('Na pewno chcesz usunąć ?')">Usuń osobę</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="add" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Nowa osoba</a>
<a href="/admin/adminHome" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Panel administratora</a>
</body>
</html>
