<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="w3-panel">
    <h1>Edycja lub dodawanie produktu</h1>
    <hr/>

    <form:form method="post" modelAttribute="product">

        <span style='width: 17%; display: inline-block'>Nazwa:</span><form:input cssStyle="width: 40%" path="name"/><form:errors path="name" cssClass="error"/><br><br>
        <hr>

        <span style='width: 17%; display: inline-block'>Umowa główna: </span><form:select cssStyle="width: 40%" path="mainCover">
        <form:option value="0" label="--Wybierz umowę główną--"/>
        <form:options items="${mainCovers}" itemLabel="name" itemValue="id"/>
        </form:select>
        <form:errors path="mainCover" cssClass="error"/>
        <hr>

        <span style='width: 17%; display: inline-block'>Umowy dodatkowe: </span><form:select cssStyle="width: 40%" path="riders" multiple="true">
        <form:option value="0" label="--Wybierz jedną lub kilka umów dodatkowych--"/>
        <form:options items="${riderList}" itemLabel="name" itemValue="id"/>
        </form:select>
        <form:errors path="riders" cssClass="error"/>
        <hr>

        <input class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge" type="submit"
               value="Zapisz">

        <a href="${pageContext.request.contextPath}/product/all" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Powrót</a>

        <a href="${pageContext.request.contextPath}/admin/adminHome" class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Panel administratora</a>


</form:form>
</div>

