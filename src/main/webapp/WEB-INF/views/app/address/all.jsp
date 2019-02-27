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
<h1>Adresy w bazie danych</h1>
<table border="1">
    <thead>
    <tr>
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
            <td><a href="/address/edit/${address.id}">Edytuj adres</a></td>
            <td><a href="/address/delete/${address.id}" onclick="return confirm
            ('Na pewno chcesz usunąć ?')">Usuń adres</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="add">Nowy adres</a>
<%@include file="../elements/footer.jsp" %>
</body>
</html>
