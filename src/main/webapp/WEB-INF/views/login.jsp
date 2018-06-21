<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.06.2018
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <h1>Login Page</h1>

    <form action="<c:url value="/servlet/login"/>" method="post">
        <label for="username">Username</label>
        <input name="username" id="username" type="text">

        <label for="password">Password</label>
        <input name="password" id="password" type="password">

        <button type="submit">Login</button>
    </form>

    Username: <c:out value="${username}" />
    </br>
    Password: <c:out value="${password}" />
</body>
</html>
