<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="w3-panel">
    <h1>Edycja lub dodawanie grupy</h1>
    <hr/>

    <form:form method="post" modelAttribute="group">


        <span style='width: 15%; display: inline-block'>Nazwa:</span><form:input cssStyle="width: 30%" path="name"/><form:errors path="name" cssClass="error"/><br><br>
        <hr>


        <span style='width: 15%; display: inline-block'>Firma:</span><form:select cssStyle="width: 30%" path="company">
        <form:option value="0" label="--Wybierz firmę--"/>
        <form:options items="${companies}" itemLabel="name" itemValue="id"/>
        </form:select>
        <form:errors path="company" cssClass="error"/>
        <hr>

        <span style='width: 15%; display: inline-block'>Produkt:</span><form:select cssStyle="width: 30%" path="product">
        <form:option value="0" label="--Wybierz produkt--"/>
        <form:options items="${products}" itemLabel="name" itemValue="id"/>
        </form:select>
        <form:errors path="product" cssClass="error"/>
        <hr>


        <input class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge" type="submit"
               value="Zapisz">

        <a href="${pageContext.request.contextPath}/group/all" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Powrót</a>

        <a href="${pageContext.request.contextPath}/admin/adminHome" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Panel administratora</a>


</form:form>
</div>

