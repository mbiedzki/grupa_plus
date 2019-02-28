<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <style>
        <%@include file="../css/style.css"%>
        <%@include file="../css/w3.css" %>
    </style>
    <title>Address</title>
</head>
<body>
<%@include file="../elements/header.jsp" %>
<%@include file="../address/details.jsp" %>
<a href="/address/all">Powrót</a>
<%@include file="../elements/footer.jsp" %>
</body>
</html>
