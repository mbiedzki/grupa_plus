<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="w3-panel">
    <h1>Edycja lub dodawanie umowy dodatkowej</h1>
    <hr/>

    <form:form method="post" modelAttribute="rider">

        <span style='width: 20%; display: inline-block'>Nazwa umowy: </span><form:input path="name"/><form:errors
            path="name" cssClass="error"/><br><br>
        <span style='width: 20%; display: inline-block'>Opis: </span><form:input path="description"/><form:errors
            path="description" cssClass="error"/><br><br>
        <span style='width: 20%; display: inline-block'>Składka roczna: </span><form:input path="premium"/><form:errors
            path="premium" cssClass="error"/><br><br>
        <span style='width: 20%; display: inline-block'>Suma ubezpieczenia: </span><form:input
            path="sumAssured"/><form:errors path="sumAssured" cssClass="error"/><br><br>
        <span style='width: 20%; display: inline-block'>Prowizja roczna </span><form:input
            path="commission"/><form:errors path="commission" cssClass="error"/><br><br>
        <hr/>
        <input class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge" type="submit"
               value="Zapisz">

        <a href="${pageContext.request.contextPath}/rider/all"
           class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Powrót</a>

        <a href="${pageContext.request.contextPath}/admin/adminHome"
           class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Panel administratora</a>

    </form:form>
</div>

