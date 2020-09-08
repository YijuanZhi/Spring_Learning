<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:c="http://java.sun.com/jsp/jstl/core"
    xmlns:fn="http://java.sun.com/jsp/jstl/functions" >
    <head><title>Hello ${userName}</title></head>
    <body style="text-align: center;">
    <c:choose>
   	<c:when test="${not empty invalidUser and !invalidUser}">
	    <h2>Welcome ${userName} </h2>
		<a href="<c:url value='/logout'/>" >Log out</a>
   		<h2>Add new employee</h2>
		<form action="<c:url value='/addEmp'/>" method="post">
		    <table align="center">
			    <tr><td>First Name:</td><td>
			    <input type="text" name="firstName" required="required"/>
			    </td></tr>
			    <tr><td>Last Name:</td><td>
			    <input type="text" name="lastName" required="required"/>
			    <tr><td>Age:</td><td>
			    <input type="number" name="age"/>
			    </td></tr>
			    <tr><td>
			    	<input type="submit">
		   			<a href="<c:url value='/success.jsp'/>" >Back</a>
			    </td></tr>
		    </table>
	    </form>
	    <c:if test="${not empty empList}">
			    Existing Employee
			    <table align="center">
				    <c:forEach items="${empList}" var="emp">
				    <tr>
				    	<td>First Name:</td>
				    	<td>${emp.firstName}</td>
				    	<td>Last Name:</td>
				    	<td>${emp.lastName}</td>
				    	<td>Age:</td>
				    	<td>${emp.age}</td>
				    </tr>
				    </c:forEach>
			    </table>
	    </c:if>
   	</c:when>
   	<c:otherwise>
   		Please Log in first.<a href="<c:url value='/'/>" >Log in</a>
   	</c:otherwise>
   	</c:choose>
   </body>
</html>