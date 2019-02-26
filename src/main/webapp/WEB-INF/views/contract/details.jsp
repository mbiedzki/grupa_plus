<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<span>
    <h1>Edycja lub dodawanie umowy</h1>

    <form:form method="post" modelAttribute="contract">

        Ubezpieczony: <form:select path="insured">
        <form:option value="0" label="--Wybierz ubezpieczonego--"/>
        <form:options items="${insureds}" itemLabel="fullName" itemValue="id"/>
        </form:select>
        <form:errors path="insured" cssClass="error"/>
        <hr>

        Uposażony: <form:select path="beneficiary">
        <form:option value="0" label="--Wybierz uposażonego--"/>
        <form:options items="${beneficiaries}" itemLabel="fullName" itemValue="id"/>
        </form:select>
        <form:errors path="beneficiary" cssClass="error"/>
        <hr>

        Grupa: <form:select path="contractGroup">
        <form:option value="0" label="--Wybierz grupę--"/>
        <form:options items="${contractGroups}" itemLabel="name" itemValue="id"/>
        </form:select>
        <form:errors path="contractGroup" cssClass="error"/>
        <hr>

        <input type="submit" value="Zapisz">


</form:form>
</span>

