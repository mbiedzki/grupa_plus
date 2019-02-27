<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style><%@include file="../css/style.css"%></style>
    <title>Adresy</title>
</head>
<%@include file="../elements/header.jsp" %>
<body>
<h1>Osoby w bazie danych</h1>

<h1>Administratorzy</h1>
<table border="1">
    <thead>
    <tr>
        <td>Imię</td>
        <td>Nazwisko</td>
        <td>PESEL</td>
        <td>Zmiana uprawnień</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${admins}" var="user">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.pesel}</td>
            <td><a href="/admin/edit/${user.id}">Zmień uprawnienia</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h1>Obsługa HR</h1>
<table border="1">
    <thead>
    <tr>
        <td>Imię</td>
        <td>Nazwisko</td>
        <td>PESEL</td>
        <td>Zmiana uprawnień</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${hrs}" var="user">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.pesel}</td>
            <td><a href="/admin/edit/${user.id}">Zmień uprawnienia</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h1>Wszystkie osoby</h1>
<table border="1">
    <thead>
    <tr>
        <td>Imię</td>
        <td>Nazwisko</td>
        <td>PESEL</td>
        <td>Zmiana uprawnień</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.pesel}</td>
            <td><a href="/admin/edit/${user.id}">Zmień uprawnienia</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="add">Nowa osoba</a>
<%@include file="../elements/footer.jsp" %>
</body>
</html>
