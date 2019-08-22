<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Login</title>
</head>
<body>
<h2> Welcome to Task Management Login </h2>
${message}
<form:form action="check" modelAttribute="task" method="GET">
UserEmail:<form:input path="user_Email" required="true"/>
UserPassword :<form:password path="user_Password" required="true"/>
<input type="submit" value="Task Login"/>

</form:form>
<a href="register"><b>Register</b></a>

</body>
</html>