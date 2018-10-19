<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h1><c:out value="${message}"/></h1>

<ul>
    <c:forEach var="user" items="${users}" >
        <li><c:out value="${user}" /></li>
    </c:forEach>
</ul>

</body>
</html>
