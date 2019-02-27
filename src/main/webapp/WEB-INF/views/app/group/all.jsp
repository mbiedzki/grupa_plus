<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style><%@include file="../css/style.css"%></style>
    <title>Grupy</title>
</head>
<%@include file="../elements/header.jsp" %>
<body>
<h1>Grupy w bazie danych</h1>

<c:if test="${deleteError==true}">
    <span style="color: red;">Nie można usunąć grupy, jest przypisana do umowy</span>
</c:if>

<table border="1">
    <thead>
    <tr>
        <td>Nazwa</td>
        <td>Firma</td>
        <td>Produkt</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.name}</td>
            <td>${group.company.name}</td>
            <td>${group.product.name}</td>
            <td><a href="/group/edit/${group.id}">Edytuj grupę</a></td>
            <td><a href="/group/delete/${group.id}" onclick="return confirm
            ('Na pewno chcesz usunąć ?')">Usuń grupę</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="add">Nowa grupa</a>
<%@include file="../elements/footer.jsp" %>
</body>
</html>
