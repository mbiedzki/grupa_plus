<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <style>
        <%@include file="../css/style.css"%>
        <%@include file="../css/w3.css" %>
    </style>
    <title>Pracownik</title>
</head>
<%@include file="../elements/header.jsp" %>
<body>



<div class="w3-panel w3-large">
    <h1>Twoje umowy w bazie danych</h1>
${user.firstName}
${user.lastName}<br>
PESEL : ${user.pesel}<br>
Telefon : ${user.phone}<br>
Email: ${user.email}
</div>
<hr>

<table class="w3-table-all">
    <thead>
    <tr class="w3-blue">
        <td>Nr</td>
        <td>Nazwa grupy</td>
        <td>Nazwa produktu</td>
        <td>Uposażony</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${contracts}" var="contract">
        <tr>
            <td>${contract.id}</td>
            <td>${contract.contractGroup.name}</td>
            <td>${contract.contractGroup.product.name}</td>
            <td>${contract.beneficiary}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<a href="${pageContext.request.contextPath}/password/change" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge" onclick="return confirm
            ('Na pewno chcesz zmienić hasło ?')">Zmiana hasła</a>

<a href="${pageContext.request.contextPath}/employee/logout" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge" onclick="return confirm
            ('Na pewno chcesz się wylogować ?')">Wylogowanie</a>
</body>
</html>
