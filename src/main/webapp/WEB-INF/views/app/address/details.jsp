<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="w3-panel">
    <%@include file="../css/w3.css" %>
    <h1>Edycja lub dodawanie adresu</h1>

    <form:form method="post" modelAttribute="address">

        Ulica: <form:input path="street"/><form:errors path="street" cssClass="error"/><br><br>
        Nr domu: <form:input path="number"/><form:errors path="number" cssClass="error"/><br><br>
        Nr mieszkania: <form:input path="apartment"/><form:errors path="apartment" cssClass="error"/><br><br>
        Kod: <form:input path="zip"/><form:errors path="zip" cssClass="error"/><br><br>
        Miasto: <form:input path="city"/><form:errors path="city" cssClass="error"/><br><br>

        <input class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge" type="submit"
               value="Zapisz">

        <a href="${pageContext.request.contextPath}/address/all"
           class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Powrót</a>

        <a href="${pageContext.request.contextPath}/admin/adminHome"
           class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Panel administratora</a>

    </form:form>
</div>

