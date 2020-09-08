<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:c="http://java.sun.com/jsp/jstl/core"
    xmlns:fn="http://java.sun.com/jsp/jstl/functions" >
    <head><title>Hello</title></head>
    <body style="text-align: center;">
   
     <h2>Log In</h2>
	<c:if test="${invalidUser}"><p style="color: red">Incorrect User Name or Password</p></c:if>
    <form action="<c:url value='/login'/>" method="post">
    <table align="center">
    	<tr>
    		<td>
    			<label>User Name:</label>
    		</td>
    		<td>
				<input type="text" name="userName"/>
    		</td>
    	</tr>
    	<tr>
    		<td>
    			<label>Password:</label>
    		</td>
    		<td>
				<input type="password" name="password"/>
    		</td>
    	</tr>
    	<tr>
    		<td>
				<input value="Submit" type="submit"/>
    		</td>
    		<td>
				<input type="reset" value="Reset" />
    		</td>
    	</tr>
    </table>
	</form>
    </body>
</html>
