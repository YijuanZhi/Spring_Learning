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
    <title>Todo Items</title>
</head>
<body>
    <div align = "center">

        <c:url var="addUrl" value="${Mappings.ADD_ITEM}" />
        <a href="${addUrl}">New Item</a>

        <table border="1" cellpadding="5">

            <caption><h2>Todo Items</h2></caption>

            <tr>
                <th>Title</th>
                <th>Deadline</th>
                <th>Details</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <c:forEach var="item" items="${wtfTodoData.items}">

                <c:url var="delete" value="${Mappings.DELETE_ITEM}">
                    <c:param name="id" value="${item.id}"/>
                </c:url>

                <c:url var="edit" value="${Mappings.ADD_ITEM}">
                    <c:param name="id" value="${item.id}"/>
                </c:url>

                <c:url var="details" value="${Mappings.VIEW_ITEM}">
                    <c:param name="id" value="${item.id}" />
                </c:url>

                <tr>
                    <td><c:out value="${item.title}"/></td>
                    <td><c:out value="${item.deadline}"/></td>
                    <td><a href="${details}">Details</a></td>
                    <td><a href="${edit}">Edit</a> </td>
                    <td><a href="${delete}">Delete</a> </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
