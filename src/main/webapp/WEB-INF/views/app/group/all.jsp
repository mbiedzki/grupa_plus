<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        <%@include file="../css/style.css"%>
        <%@include file="../css/w3.css" %>
    </style>
    <title>Grupy</title>
</head>
<%@include file="../elements/header.jsp" %>
<body>
<div class="w3-panel">
    <h1>Grupy w bazie danych</h1>

    <c:if test="${deleteError==true}">
        <div class="w3-panel w3-red w3-display-container">
    <span onclick="this.parentElement.style.display='none';
            <c:set var="deleteError" value="false" scope="session" />"
          class="w3-button w3-large w3-display-topright">&times;</span>
            <p>Nie można usunąć grupy, jest przypisana do umowy !</p>
        </div>
    </c:if>

    <table class="w3-table-all">
        <thead>
        <tr class="w3-blue">
            <td>Nazwa</td>
            <td>Firma</td>
            <td>Produkt</td>
            <td>Edycja</td>
            <td>Usuwanie</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${groups}" var="group">
            <tr>
                <td>${group.name}</td>
                <td>${group.company.name}</td>
                <td>${group.product.name}</td>
                <td><a href="${pageContext.request.contextPath}/group/edit/${group.id}">Edytuj grupę</a></td>
                <td><a href="${pageContext.request.contextPath}/group/delete/${group.id}" onclick="return confirm
            ('Na pewno chcesz usunąć ?')">Usuń grupę</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="${pageContext.request.contextPath}/group/add"
       class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Nowa grupa</a>
    <a href="${pageContext.request.contextPath}/admin/adminHome"
       class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Panel administratora</a>
</div>
</body>
</html>
