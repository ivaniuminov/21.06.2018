<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.06.2018
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category</title>
</head>
<body>
    <h1>Category: <c:out value="${category.categoryName}"/></h1>

    <p><c:out value="${category.description}"/></p>

    <h3>Products</h3>

    <c:forEach var="p" items="${category.productList}">
        <h4><a href="<c:out value="/servlet/product?p_id=${p.id}"/>"><c:out value="${p.name}"/></a></h4>
    </c:forEach>
</body>
</html>
