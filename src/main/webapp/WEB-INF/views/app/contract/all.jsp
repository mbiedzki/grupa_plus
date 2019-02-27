<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style><%@include file="../css/style.css"%></style>
    <title>Umowy</title>
</head>
<%@include file="../elements/header.jsp" %>
<body>
<h1>Umowy w bazie danych</h1>
<table border="1">
    <thead>
    <tr>
        <td>Nr</td>
        <td>Nazwa grupy</td>
        <td>Ubezpieczony</td>
        <td>Uposażony</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${contracts}" var="contract">
        <tr>
            <td>${contract.id}</td>
            <td>${contract.contractGroup.name}</td>
            <td>${contract.insured}</td>
            <td>${contract.beneficiary}</td>
            <td><a href="/contract/edit/${contract.id}">Edytuj umowę</a></td>
            <td><a href="/contract/delete/${contract.id}" onclick="return confirm
            ('Na pewno chcesz usunąć ?')">Usuń umowę</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="add">Nowa umowa</a>
<%@include file="../elements/footer.jsp" %>
</body>
</html>
