<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style><%@include file="/WEB-INF/views/css/style.css"%></style>
    <title>Produkty</title>
</head>
<%@include file="/WEB-INF/views/elements/header.jsp" %>
<body>
<h1>Produkty w bazie danych</h1>

<c:if test="${deleteError==true}">
    <span style="color: red;">Nie można usunąć produktu, są do niego przypisane grupy</span>
</c:if>

<table border="1">
    <thead>
    <tr>
        <td>Nazwa</td>
        <td>Umowa główna</td>
        <td>Umowy dodatkowe</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.mainCover}</td>
            <td>${product.riders}</td>
            <td><a href="/product/edit/${product.id}">Edytuj produkt</a></td>
            <td><a href="/product/delete/${product.id}" onclick="return confirm
            ('Na pewno chcesz usunąć ?')">Usuń produkt</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="add">Nowy produkt</a>
<%@include file="/WEB-INF/views/elements/footer.jsp" %>
</body>
</html>
