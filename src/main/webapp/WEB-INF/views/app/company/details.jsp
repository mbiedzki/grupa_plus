<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="w3-panel">
    <h1>Edycja lub dodawanie firmy</h1>
    <hr/>

    <form:form method="post" modelAttribute="company">

        <span style='width: 15%; display: inline-block'>Nazwa firmy: </span><form:input path="name"/><form:errors path="name" cssClass="error"/><br><br>
        <span style='width: 15%; display: inline-block'>Ulica: </span><form:input path="street"/><form:errors path="street" cssClass="error"/><br><br>
        <span style='width: 15%; display: inline-block'>Nr domu: </span><form:input path="number"/><form:errors path="number" cssClass="error" /><br><br>
        <span style='width: 15%; display: inline-block'>Nr mieszkania: </span><form:input path="apartment"/><form:errors path="apartment" cssClass="error"/><br><br>
        <span style='width: 15%; display: inline-block'>Kod: </span><form:input path="zip"/><form:errors path="zip" cssClass="error"/><br><br>
        <span style='width: 15%; display: inline-block'>Miasto: </span><form:input path="city"/><form:errors path="city" cssClass="error"/><br><br>
<hr/>
        <input class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge" type="submit"
               value="Zapisz">

        <a href="${pageContext.request.contextPath}/company/all" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Powrót</a>

        <a href="${pageContext.request.contextPath}/admin/adminHome" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Panel administratora</a>

    </form:form>
</div>

