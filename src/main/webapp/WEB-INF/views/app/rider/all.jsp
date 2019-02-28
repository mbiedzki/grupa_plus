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
<h1>Umowy dodatkowe w bazie danych</h1>

<c:if test="${deleteError==true}">
    <div align="center" class="w3-xxlarge w3-panel w3-red">
        Nie można usunąć umowy dodatkowej, jest przypisana do produktu
    </div>
</c:if>

<table class="w3-table-all">
    <thead>
    <tr class="w3-blue">
        <td>Nazwa umowy</td>
        <td>Opis</td>
        <td>Składka roczna</td>
        <td>Suma ubezpieczenia</td>
        <td>Prowizja roczna</td>
        <td>Edycja</td>
        <td>Usuwanie</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${riders}" var="rider">
        <tr>
            <td>${rider.name}</td>
            <td>${rider.description}</td>
            <td>${rider.premium}</td>
            <td>${rider.sumAssured}</td>
            <td>${rider.commission}</td>
            <td><a href="/rider/edit/${rider.id}">Edytuj umowę</a></td>
            <td><a href="/rider/delete/${rider.id}" onclick="return confirm
            ('Na pewno chcesz usunąć ?')">Usuń umowę</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="add" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Nowa umowa dodatkowa</a>
<a href="/admin/adminHome" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Panel administratora</a>
</body>
</html>
