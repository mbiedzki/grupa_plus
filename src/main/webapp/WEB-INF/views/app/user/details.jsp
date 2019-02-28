<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="w3-panel">
    <h1>Edycja lub dodawanie osoby</h1>
    <hr>

    <form:form method="post" modelAttribute="user">

        Imię: <form:input path="firstName"/><form:errors path="firstName" cssClass="error"/>
        Nazwisko: <form:input path="lastName"/><form:errors path="lastName" cssClass="error"/>
        PESEL: <form:input path="pesel"/><form:errors path="pesel" cssClass="error"/><br><br>
        Telefon: <form:input path="phone"/><form:errors path="phone" cssClass="error"/>
        Email: <form:input path="email"/><form:errors path="email" cssClass="error"/>

        <hr>
        Adres:<br><br>
        Ulica: <form:input path="address.street"/><form:errors path="address.street" cssClass="error"/>
        Nr domu: <form:input path="address.number"/><form:errors path="address.number" cssClass="error" />
        Nr mieszkania: <form:input path="address.apartment"/><form:errors path="address.apartment" cssClass="error"/><br><br>
        Kod: <form:input path="address.zip"/><form:errors path="address.zip" cssClass="error"/>
        Miasto: <form:input path="address.city"/><form:errors path="address.city" cssClass="error"/>
        <hr>


        Firma: <form:select path="company">
        <form:option value="0" label="--Wybierz firmę--"/>
        <form:options items="${companies}" itemLabel="name" itemValue="id"/>
        </form:select>
        <form:errors path="company" cssClass="error"/>
        <hr>

        <input class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge" type="submit"
               value="Zapisz">

        <a href="/user/all" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Powrót</a>

        <a href="/admin/adminHome" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Panel administratora</a>


</form:form>
</div>

