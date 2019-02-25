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
<h1>Umowy główne w bazie danych</h1>

<c:if test="${deleteError==true}">
    <span style="color: red;">Nie można usunąć umowy dodatkowej, jest przypisana do produktu</span>
</c:if>

<table border="1">
    <thead>
    <tr>
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
<a href="add">Nowa umowa dodatkowa</a>
<%@include file="/WEB-INF/views/elements/footer.jsp" %>
</body>
</html>
