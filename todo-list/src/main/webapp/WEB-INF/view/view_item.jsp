<%--
  Created by IntelliJ IDEA.
  User: zaczhi
  Date: 9/7/20
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.antra.util.Mappings" %>
<html>
<head>
    <title>View Item</title>
</head>
<body>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>View Item</h2></caption>

            <tr>
                <td>Title</td>
                <td>Details</td>
                <td>Deadline</td>
            </tr>

            <tr>
                <td>${todoItem.title}</td>
                <td>${todoItem.details}</td>
                <td>${todoItem.deadline}</td>
            </tr>
        </table>

        <c:url var="backToItemList" value="${Mappings.ITEMS}" />
        <a href="${backToItemList}">Back to Item List</a>
    </div>
</body>
</html>
