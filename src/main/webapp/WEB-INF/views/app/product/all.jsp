<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        <%@include file="../css/style.css"%>
        <%@include file="../css/w3.css" %>
    </style>
    <title>Produkty</title>
</head>
<%@include file="../elements/header.jsp" %>
<body>
<div class="w3-panel">
<h1>Produkty w bazie danych</h1>

<c:if test="${deleteError==true}">
    <div class="w3-panel w3-red w3-display-container">
    <span onclick="this.parentElement.style.display='none';
            <c:set var="deleteError" value="false" scope="session" />"
          class="w3-button w3-large w3-display-topright">&times;</span>
        <p>Nie można usunąć produktu, są do niego przypisane grupy !</p>
    </div>
</c:if>

<table class="w3-table-all">
    <thead>
    <tr class="w3-blue">
        <td>Nazwa</td>
        <td>Umowa główna</td>
        <td>Umowy dodatkowe</td>
        <td>Edycja</td>
        <td>Usuwanie</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.mainCover}</td>
            <td>${product.riders}</td>
            <td><a href="${pageContext.request.contextPath}/product/edit/${product.id}">Edytuj produkt</a></td>
            <td><a href="${pageContext.request.contextPath}/product/delete/${product.id}" onclick="return confirm
            ('Na pewno chcesz usunąć ?')">Usuń produkt</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="${pageContext.request.contextPath}/product/add" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Nowy produkt</a>
<a href="${pageContext.request.contextPath}/admin/adminHome" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Panel administratora</a>
</div>
</body>
</html>
