<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="w3-panel w3-large">
    <h1>Edycja lub dodawanie grupy</h1>

    <form:form method="post" modelAttribute="group">


        Nazwa: <form:input path="name"/><form:errors path="name" cssClass="error"/><br><br>
        <hr>


        Firma: <form:select path="company">
        <form:option value="0" label="--Wybierz firmę--"/>
        <form:options items="${companies}" itemLabel="name" itemValue="id"/>
        </form:select>
        <form:errors path="company" cssClass="error"/>
        <hr>

        Produkt: <form:select path="product">
        <form:option value="0" label="--Wybierz produkt--"/>
        <form:options items="${products}" itemLabel="name" itemValue="id"/>
        </form:select>
        <form:errors path="product" cssClass="error"/>
        <hr>


        <input class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge" type="submit"
               value="Zapisz">

        <a href="/group/all" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Powrót</a>

        <a href="/admin/adminHome" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Panel administratora</a>


</form:form>
</div>

