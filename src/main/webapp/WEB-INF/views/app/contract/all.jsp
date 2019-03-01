<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <style>
        <%@include file="../css/style.css"%>
        <%@include file="../css/w3.css" %>
    </style>
    <title>Umowy ubezpieczeniowe</title>
</head>
<%@include file="../elements/header.jsp" %>
<body>
<h1>Umowy ubezpieczeniowe w bazie danych</h1>


<table class="w3-table-all">
    <thead>
    <tr class="w3-blue">
        <td>Nr</td>
        <td>Nazwa grupy</td>
        <td>Ubezpieczony</td>
        <td>Uposażony</td>
        <td>Zmiany</td>
        <td>Usuwanie</td>
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
<a href="add" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Nowe ubezpieczenie</a>
<a href="/admin/adminHome" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Panel administratora</a>
</body>
</html>
