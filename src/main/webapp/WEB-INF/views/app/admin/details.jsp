<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<c:if test="${peselError==true}">
    <div class="w3-panel w3-red w3-display-container">
    <span onclick="this.parentElement.style.display='none';"
          class="w3-button w3-large w3-display-topright">&times;</span>
        <p>Nie można zapisać danych osoby, taki nr PESEL już jest zapisany w bazie !</p>
    </div>
</c:if>

<div class="w3-panel">
    <h1>Edycja osoby i jej uprawnień</h1>
    <hr/>


    <form:form method="post" modelAttribute="user">


        <div class="row">

            <div class="column">
                <span style='width: 20%; display: inline-block'>Imię: </span><form:input path="firstName"/><form:errors
                    path="firstName" cssClass="error"/><br><br>
                <span style='width: 20%; display: inline-block'>Nazwisko: </span><form:input
                    path="lastName"/><form:errors
                    path="lastName" cssClass="error"/><br><br>
                <span style='width: 20%; display: inline-block'>PESEL: </span><form:input path="pesel"/><form:errors
                    path="pesel" cssClass="error"/><br><br>
                <span style='width: 20%; display: inline-block'>Telefon: </span><form:input path="phone"/><form:errors
                    path="phone" cssClass="error"/><br><br>
                <span style='width: 20%; display: inline-block'>Email: </span><form:input path="email"/><form:errors
                    path="email" cssClass="error"/>
                <form:hidden path="password"/>
            </div>


            <div class="column">
                <span style='width: 20%; display: inline-block'>Ulica: </span><form:input
                    path="address.street"/><form:errors
                    path="address.street" cssClass="error"/><br><br>
                <span style='width: 20%; display: inline-block'>Nr domu: </span><form:input
                    path="address.number"/><form:errors
                    path="address.number" cssClass="error"/><br><br>
                <span style='width: 20%; display: inline-block'>Nr mieszkania: </span><form:input
                    path="address.apartment"/><form:errors path="address.apartment"
                                                           cssClass="error"/><br><br>
                <span style='width: 20%; display: inline-block'>Kod: </span><form:input path="address.zip"/><form:errors
                    path="address.zip" cssClass="error"/><br><br>
                <span style='width: 20%; display: inline-block'>Miasto: </span><form:input
                    path="address.city"/><form:errors
                    path="address.city" cssClass="error"/>
            </div>
        </div>
        <hr/>

        <span style='width: 10%; display: inline-block'>Firma:</span><form:select path="company">
        <form:option value="0" label="--Wybierz firmę--"/>
        <form:options items="${companies}" itemLabel="name" itemValue="id"/>
    </form:select><form:errors path="company" cssClass="error"/>
        <hr>

        <div class="row">
            <div class="column">
                <span style='width: 25%; display: inline-block'>Administrator:</span><form:checkbox
                    path="admin"/><form:errors
                    path="admin" cssClass="error"/><br/><br/>
                <span style='width: 25%; display: inline-block'>Obsługa HR: </span><form:checkbox
                    path="hr"/><form:errors
                    path="hr" cssClass="error"/>
            </div>
            <div class="column">
                <span style='width: 25%; display: inline-block'>Nowe hasło: </span><input name="newPassword">
                <p style="color: gray">(jeżeli nic nie wpiszesz, hasło pozostanie bez zmian)</p>
            </div>
        </div>

        <hr>
        <a href="${pageContext.request.contextPath}/admin/all"
           class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Powrót</a>
        <input class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge" type="submit"
               onclick="return confirm
            ('Na pewno chcesz zmienić uprawnienia ?')" value="Zapisz"><form:errors path="admin" cssClass="error"/>
        <a href="${pageContext.request.contextPath}/admin/adminHome"
           class="w3-button w3-xlarge w3-border w3-border-blue w3-round-xxlarge">Panel administratora</a>

    </form:form>
</div>
