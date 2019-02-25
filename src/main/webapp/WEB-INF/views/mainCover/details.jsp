<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<span>
    <h1>Edycja lub dodawanie umowy</h1>

    <form:form method="post" modelAttribute="mainCover">

        Nazwa umowy: <form:input path="name"/><form:errors path="name" cssClass="error"/><br><br>
        Opis: <form:input path="description"/><form:errors path="description" cssClass="error"/><br><br>
        Składka roczna: <form:input path="premium"/><form:errors path="premium" cssClass="error" /><br><br>
        Suma ubezpieczenia: <form:input path="sumAssured"/><form:errors path="sumAssured" cssClass="error"/><br><br>
        Prowizja roczna <form:input path="commission"/><form:errors path="commission" cssClass="error"/><br><br>

        <input type="submit" value="Zapisz">

    </form:form>
</span>

