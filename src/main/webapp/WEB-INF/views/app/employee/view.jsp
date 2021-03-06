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
    <h2>Twoje umowy w bazie danych</h2>
    <hr/>

    <div class="row">
        <div class="column">
            ${user.firstName}
            ${user.lastName}<br/>
            PESEL : ${user.pesel}
        </div>
        <div class="column">
            Telefon : ${user.phone}<br>
            Email: ${user.email}
        </div>
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
    <hr>

    <c:if test="${emailSent==true}">
        <div class="w3-panel w3-light-gray w3-display-container">
        <span onclick="this.parentElement.style.display='none';
            <c:set var="emailSent" value="0" scope="session" />"
              class="w3-button w3-large w3-display-topright">&times;</span>
            <p> Podsumowanie zostało wysłane na podany adres...</p>
        </div>
    </c:if>


    <div class="w3-container">
        <h2>Wyślij podsumowanie</h2>
        <form method="post">

            <div class="w3-container w3-large">
                <p><input type="radio" name="summary" value="send" checked>Na adres email
                    <input class="w3-round-large" type="email" name="emailToSend" value="${user.email}"></p>
                <p><input type="radio" name="summary" value="download">Zapisz na dysku</p>
                <p><input type="radio" name="summary" value="display">Wyświetl w przeglądarce</p>
            </div>


            <hr>
            <input class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge" type="submit"
                   value="Wyślij">
            <a href="${pageContext.request.contextPath}/password/change"
               class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge"
               onclick="return confirm ('Na pewno chcesz zmienić hasło ?')">Zmiana hasła</a>

            <a href="${pageContext.request.contextPath}/employee/logout"
               class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge" onclick="return confirm
            ('Na pewno chcesz się wylogować ?')">Wylogowanie</a>

        </form>
    </div>
</div>
</body>
</html>
