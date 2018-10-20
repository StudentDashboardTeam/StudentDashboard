<%--
  Created by IntelliJ IDEA.
  User: ryan
  Date: 10/19/18
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Codeup Student Dashboard"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <form method="POST" action="/login">
    <div class="form-group">
        <label for="username">Username</label>
        <input type="email" class="form-control" id="username" aria-describedby="emailHelp" name="username" placeholder="Enter username">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
    </div>
        <button type="button" class="btn btn-success">Success</button>
    </form>
</div>
</body>
</html>
