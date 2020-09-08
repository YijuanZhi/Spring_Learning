<%--
  Created by IntelliJ IDEA.
  User: zaczhi
  Date: 9/5/20
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.antra.util.Mappings" %>
<html>
<head>
    <title>Todo-List Application</title>
</head>
<body>
    <div align = "center">
        <c:url var="itemsLink" value="${Mappings.ITEMS}" />
        <h2><a href="${itemsLink}">Show Todo Items</a> </h2>

    </div>
</body>
</html>
