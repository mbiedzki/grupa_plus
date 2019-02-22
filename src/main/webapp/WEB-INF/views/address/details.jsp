<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<span>
    <h1>Adres</h1>

    <form:form method="post" modelAttribute="address">

        Ulica: <form:input path="street"/><br><br>
        <form:errors path="street" cssClass="error" element="div"/>
        Nr domu: <form:input path="number"/><br><br>
        <form:errors path="number" cssClass="error" element="div"/>
        Nr mieszkania: <form:input path="apartment"/><br><br>
        <form:errors path="apartment" cssClass="error" element="div"/>
        Kod: <form:input path="zip"/><br><br>
        <form:errors path="zip" cssClass="error" element="div"/>
        Miasto: <form:input path="city"/><br><br>
        <form:errors path="city" cssClass="error" element="div"/>

        <input type="submit" value="Zapisz">

    </form:form>
</span>

