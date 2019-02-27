<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home</title>
    <style>
        <%@include file="/WEB-INF/views/app/css/style.css" %>
    </style>
</head>
<body>
<%@include file="/WEB-INF/views/app/elements/header.jsp" %>
<div>
    <h1>GrupaPlus - Logowanie</h1>
</div>
<br><br>
<hr>

<form method="post">

    <input type="text" name="pesel" placeholder="podaj PESEL">
    <input type="password" name="password" placeholder="podaj hasło">
    <button type="submit">Zaloguj</button>

</form>


<%--<%@include file="/WEB-INF/views/app/elements/footer.jsp" %>--%>
</body>
</html>
