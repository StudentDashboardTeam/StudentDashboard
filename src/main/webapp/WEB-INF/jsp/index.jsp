<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Codeup Student Dashboard"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<h1><c:out value="${message}"/></h1>

<ul>
    <c:forEach var="user" items="${users}">
        <li><c:out value="${user}"/></li>
        <p>Users ID: <c:out value="${user.userId()}"/></p>
        <p>Username: <c:out value="${user.username()}"/></p>
        <p>Email Address: <c:out value="${user.email()}"/></p>
    </c:forEach>
</ul>

</body>
</html>
