<%--
  Created by IntelliJ IDEA.
  User: ryan
  Date: 10/19/18
  Time: 6:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<jsp:include page="/WEB-INF/partials/head.jsp">--%>
        <%--<jsp:param name="title" value="Codeup Student Dashboard"/>--%>
    <%--</jsp:include>--%>
<%--</head>--%>
<%--<body>--%>
<%--<jsp:include page="/WEB-INF/partials/navbar.jsp"/>--%>
<%--<div class="container">--%>
    <%--<form method="POST" action="/register-user">--%>
        <%--<fieldset>--%>
    <%--<div class="form-group">--%>
        <%--<label for="username">Username</label>--%>
        <%--<input type="email" class="form-control" id="username" aria-describedby="emailHelp" name="username" placeholder="Enter email">--%>
        <%--&lt;%&ndash;<small id="emailHelp" class="form-text text-muted"></small>&ndash;%&gt;--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
        <%--<label for="password">Password</label>--%>
        <%--<input type="password" class="form-control" id="password" name="password" placeholder="Password">--%>
    <%--</div>--%>
    <%--<button type="button" class="btn btn-success">Success</button>--%>
        <%--</fieldset>--%>
    <%--</form>--%>

<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8" />
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Codeup Student Dashboard"/>
    </jsp:include>
</head>
<body>
<h1>Create an account</h1>
<form th:action="@{/register}" method="POST" th:object="${user}">
    <label for="username">Username</label>
    <input id="username" th:field="*{username}" />

    <label for="email">Email</label>
    <input id="email" th:field="*{email}" />

    <label for="password">Password</label>
    <input id="password" type="password" th:field="*{password}" />
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<%--<form method="POST" action="/register">--%>
    <%--<div class="form-group">--%>
        <%--<label for="username">Username</label>--%>
        <%--<input type="text" class="form-control" id="username" aria-describedby="emailHelp" name="username" placeholder="Enter username">--%>
        <%--&lt;%&ndash;<small id="emailHelp" class="form-text text-muted"></small>&ndash;%&gt;--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
        <%--<label for="email">Username</label>--%>
        <%--<input type="email" class="form-control" id="email" aria-describedby="emailHelp" name="email" placeholder="Enter email">--%>
        <%--&lt;%&ndash;<small id="emailHelp" class="form-text text-muted"></small>&ndash;%&gt;--%>
    <%--</div>--%>
    <%--<div class="form-group">--%>
        <%--<label for="password">Password</label>--%>
        <%--<input type="password" class="form-control" id="password" name="password" placeholder="Password">--%>
    <%--</div>--%>
    <%--<button type="button" class="btn btn-success">Success</button>--%>
<%--</form>--%>

    <%--<input value="Sign me up!" type="submit" />--%>
<%--</form>--%>
</body>
</html>