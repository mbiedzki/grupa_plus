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
<div class="w3-panel">
    <h1>Umowy dodatkowe w bazie danych</h1>

    <c:if test="${deleteError==true}">
        <div class="w3-panel w3-red w3-display-container">
    <span onclick="this.parentElement.style.display='none';
            <c:set var="deleteError" value="false" scope="session" />"
          class="w3-button w3-large w3-display-topright">&times;</span>
            <p>Nie można usunąć umowy dodatkowej, jest przypisana do produktu !</p>
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
                <td><a href="${pageContext.request.contextPath}/rider/edit/${rider.id}">Edytuj umowę</a></td>
                <td><a href="${pageContext.request.contextPath}/rider/delete/${rider.id}" onclick="return confirm
            ('Na pewno chcesz usunąć ?')">Usuń umowę</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="${pageContext.request.contextPath}/rider/add"
       class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Nowa umowa dodatkowa</a>
    <a href="${pageContext.request.contextPath}/admin/adminHome"
       class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Panel administratora</a>
</div>
</body>
</html>
