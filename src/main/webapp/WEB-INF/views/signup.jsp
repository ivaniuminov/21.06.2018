<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.06.2018
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Signup</title>
</head>
<body>

    <h1>Please enter information:</h1>

    <form action="<c:url value="/servlet/signup"/>" method="post">
        <label for="firstName">First Name</label>
        <input type="text" name="firstName" id="firstName" />

        <label for="lastName">Last Name</label>
        <input type="text" name="lastName" id="lastName" />

        <label for="email">Email</label>
        <input type="email" name="email" id="email" />

        <label for="password">Password</label>
        <input type="password" name="password" id="password" placeholder="Enter password" />

        <label for="password2">Confirm Password</label>
        <input type="password" name="password2" id="password2" placeholder="Confirm password" />

        <button type="submit">Sign Up</button>
    </form>

</body>
</html>
