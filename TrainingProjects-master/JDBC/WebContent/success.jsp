<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:c="http://java.sun.com/jsp/jstl/core"
    xmlns:fn="http://java.sun.com/jsp/jstl/functions" >
    <head><title>Hello ${userName}</title></head>
    <body style="text-align: center;">
   <c:choose>
   	<c:when test="${not empty invalidUser and !invalidUser}">
	    <h2>Welcome ${userName} </h2>
		<a href="<c:url value='/logout'/>" >Log out</a>
	    <table align="center">
		    <tr><td>
	   		<a href="<c:url value='/addDepartment.jsp'/>">Add Department</a>
		    </td></tr>
		    <tr><td>
	   		<a href="<c:url value='/addEmployee.jsp'/>">Add Employee</a>
		    </td></tr>
	    </table>
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