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
    <span style="color: red;">Nie można usunąć umowy głównej, jest przypisana do produktu</span>
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
    <c:forEach items="${mainCovers}" var="mainCover">
        <tr>
            <td>${mainCover.name}</td>
            <td>${mainCover.description}</td>
            <td>${mainCover.premium}</td>
            <td>${mainCover.sumAssured}</td>
            <td>${mainCover.commission}</td>
            <td><a href="/mainCover/edit/${mainCover.id}">Edytuj umowę</a></td>
            <td><a href="/mainCover/delete/${mainCover.id}" onclick="return confirm
            ('Na pewno chcesz usunąć ?')">Usuń umowę</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="add">Nowa umowa główna</a>
<%@include file="/WEB-INF/views/elements/footer.jsp" %>
</body>
</html>
