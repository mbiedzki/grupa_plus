<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <style><%@include file="/WEB-INF/views/css/style.css"%></style>
    <title>Address</title>
</head>
<body>
<%@include file="/WEB-INF/views/elements/header.jsp" %>
<%@include file="/WEB-INF/views/address/details.jsp" %>
<a href="/address/all">Powrót</a>
<%@include file="/WEB-INF/views/elements/footer.jsp" %>
</body>
</html>
