<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.06.2018
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>

    <c:forEach var="c" items="${categories}">
        <h1><a href="<c:out value="/servlet/category?c_id=${c.id}"/>"><c:out value="${c.categoryName}"/></a></h1>
    </c:forEach>
</body>
</html>
