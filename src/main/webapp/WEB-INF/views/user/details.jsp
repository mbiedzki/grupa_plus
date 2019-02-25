<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<span>
    <h1>Edycja lub dodawanie osoby</h1>

    <form:form method="post" modelAttribute="user">

        Imię: <form:input path="firstName"/><form:errors path="firstName" cssClass="error"/><br><br>
        Nazwisko: <form:input path="lastName"/><form:errors path="lastName" cssClass="error"/><br><br>
        PESEL: <form:input path="pesel"/><form:errors path="pesel" cssClass="error"/><br><br>
        Telefon: <form:input path="phone"/><form:errors path="phone" cssClass="error"/><br><br>
        Email: <form:input path="email"/><form:errors path="email" cssClass="error"/><br><br>

        <hr>
        Adres:<br><br>
        Ulica: <form:input path="address.street"/><form:errors path="address.street" cssClass="error"/><br><br>
        Nr domu: <form:input path="address.number"/><form:errors path="address.number" cssClass="error" /><br><br>
        Nr mieszkania: <form:input path="address.apartment"/><form:errors path="address.apartment" cssClass="error"/><br><br>
        Kod: <form:input path="address.zip"/><form:errors path="address.zip" cssClass="error"/><br><br>
        Miasto: <form:input path="address.city"/><form:errors path="address.city" cssClass="error"/><br><br>

        Firma: <form:select path="company">
        <form:option value="0" label="--Wybierz firmę--"/>
        <form:options items="${companies}" itemLabel="name" itemValue="id"/>
        </form:select>
        <form:errors path="company" cssClass="error"/>

        <input type="submit" value="Zapisz">


</form:form>
</span>

