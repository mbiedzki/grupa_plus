<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="w3-panel">
    <h1>Edycja lub dodawanie umowy ubezpieczenia</h1>
    <hr/>

    <form:form method="post" modelAttribute="contract">


        <span style='width: 15%; display: inline-block'>Ubezpieczony: </span>
        <form:select cssStyle="width: 30%" path="insured">
            <form:option value="0" label="--Wybierz ubezpieczonego--"/>
            <form:options items="${insureds}" itemLabel="fullName" itemValue="id"/>
        </form:select>
        <form:errors path="insured" cssClass="error"/>
        <hr>

        <span style='width: 15%; display: inline-block'>Uposażony: </span>
        <form:select cssStyle="width: 30%" path="beneficiary">
            <form:option value="0" label="--Wybierz uposażonego--"/>
            <form:options items="${beneficiaries}" itemLabel="fullName" itemValue="id"/>
        </form:select>
        <form:errors path="beneficiary" cssClass="error"/>
        <hr>

        <span style='width: 15%; display: inline-block'>Grupa: </span>
        <form:select cssStyle="width: 30%" path="contractGroup">
            <form:option value="0" label="--Wybierz grupę--"/>
            <form:options items="${contractGroups}" itemLabel="name" itemValue="id"/>
        </form:select>
        <form:errors path="contractGroup" cssClass="error"/>


        <hr/>

        <input class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge" type="submit"
               value="Zapisz">

        <a href="${pageContext.request.contextPath}/contract/all"
           class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Powrót</a>

        <a href="${pageContext.request.contextPath}/admin/adminHome"
           class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Panel administratora</a>


    </form:form>

</div>



