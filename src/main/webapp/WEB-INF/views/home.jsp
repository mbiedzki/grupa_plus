<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home</title>
    <style>
        <%@include file="css/style.css" %>
    </style>
</head>
<body>
<%@include file="elements/header.jsp" %>
<div>
    <h1>GrupaPlus - strona główna</h1>
</div>
<br><br>
<hr>

<h2>
    <a href="company/all">Firmy</a>
    <a href="user/all">Osoby</a>
    <a href="address/all">Adresy</a>
</h2>
<%@include file="elements/footer.jsp" %>
</body>
</html>
