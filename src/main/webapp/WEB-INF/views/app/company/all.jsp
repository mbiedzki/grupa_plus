<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        <%@include file="../css/style.css" %>
        <%@include file="../css/w3.css" %>
    </style>
    <title>Adresy</title>
</head>
<%@include file="../elements/header.jsp" %>
<body>
<h1>Firmy w bazie danych</h1>

<c:if test="${deleteError==true}">
    <div align="center" class="w3-xxlarge w3-panel w3-red">
        Nie można usunąć firmy, są do niej przypisane osoby lub grupy
    </div>
</c:if>

<table class="w3-table-all">
    <thead>
    <tr class="w3-blue">
        <td>Nazwa firmy</td>
        <td>Adres</td>
        <td>Edycja</td>
        <td>Usuwanie</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${companies}" var="company">
        <tr>
            <td>${company.name}</td>
            <td>${company}</td>
            <td><a href="/company/edit/${company.id}">Edytuj dane firmy</a></td>
            <td><a href="/company/delete/${company.id}" onclick="return confirm
            ('Na pewno chcesz usunąć ?')">Usuń firmę</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="add" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Nowa firma</a>
<a href="/admin/adminHome" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Panel administratora</a>
</body>
</html>
