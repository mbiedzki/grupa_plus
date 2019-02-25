<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        <%@include file="/WEB-INF/views/css/style.css" %>
    </style>
    <title>Adresy</title>
</head>
<%@include file="/WEB-INF/views/elements/header.jsp" %>
<body>
<h1>Firmy w bazie danych</h1>

<c:if test="${deleteError==true}">
    <span style="color: red;">Nie można usunąć firmy, są do niej przypisane osoby</span>
</c:if>

<table border="1">
    <thead>
    <tr>
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
<a href="add">Nowa firma</a>
<%@include file="/WEB-INF/views/elements/footer.jsp" %>
</body>
</html>
