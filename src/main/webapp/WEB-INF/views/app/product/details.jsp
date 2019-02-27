<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<span>
    <h1>Edycja lub dodawanie produktu</h1>

    <form:form method="post" modelAttribute="product">

        Nazwa: <form:input path="name"/><form:errors path="name" cssClass="error"/><br><br>
        <hr>

        Umowa główna: <form:select path="mainCover">
        <form:option value="0" label="--Wybierz umowę główną--"/>
        <form:options items="${mainCovers}" itemLabel="name" itemValue="id"/>
        </form:select>
        <form:errors path="mainCover" cssClass="error"/>
        <hr>

        Umowy dodatkowe: <form:select path="riders" multiple="true">
        <form:option value="0" label="--Wybierz jedną lub kilka umów dodatkowych--"/>
        <form:options items="${riders}" itemLabel="name" itemValue="id"/>
        </form:select>
        <form:errors path="riders" cssClass="error"/>
        <hr>

        <input type="submit" value="Zapisz">


</form:form>
</span>
