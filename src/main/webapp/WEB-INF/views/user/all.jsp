<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style><%@include file="/WEB-INF/views/css/style.css"%></style>
    <title>Adresy</title>
</head>
<%@include file="/WEB-INF/views/elements/header.jsp" %>
<body>
<h1>Osoby w bazie danych</h1>
<table border="1">
    <thead>
    <tr>
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
<a href="add">Nowa osoba</a>
<%@include file="/WEB-INF/views/elements/footer.jsp" %>
</body>
</html>
