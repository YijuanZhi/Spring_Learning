<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:c="http://java.sun.com/jsp/jstl/core"
    xmlns:fn="http://java.sun.com/jsp/jstl/functions" >
    <head><title>Hello ${userName}</title></head>
    <body style="text-align: center;">
    <c:choose>
   	<c:when test="${not empty invalidUser and !invalidUser}">
	    <h2>Welcome ${userName} </h2>
		<a href="<c:url value='/logout'/>" >Log out</a>
   		<h2>Add new department</h2>
		<form action="<c:url value='/addDept'/>" method="post">
		    <table align="center">
			    <tr><td>Dept Name:</td><td>
			    <input type="text" name="deptName" required="required"/>
			    </td></tr>
			    <tr><td>Dept Email:</td><td>
			    <input type="email" name="deptEmail"/>
			    </td></tr>
			    <tr><td>
			    	<input type="submit">
		   			<a href="<c:url value='/success.jsp'/>" >Back</a>
			    </td></tr>
		    </table>
	    </form>
	     <c:if test="${not empty deptList}">
				<h4>Existing Department</h4>
			    <table align="center" border="1">
			    	<tr><th>Dept Name</th><th>Email</th><th>Employee</th></th>
				    <c:forEach items="${deptList}" var="dept">
				    <tr>
				    	<td>${dept.name}</td>
				    	<td>${dept.email}</td>
				    	<td>
				    	<c:forEach items="${dept.employeeList}" var="emp">
					    	${emp.firstName} ${emp.lastName} ${emp.age}<br>
				    	</c:forEach>
				    	</td>
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