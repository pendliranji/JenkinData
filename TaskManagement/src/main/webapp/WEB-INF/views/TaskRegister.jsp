<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration for Task Management Desk</title>
</head>
<body>

	<h2>Welcome to Task Management Registration Desk</h2>
	<form:form action="save" modelAttribute="task" method="POST">
FirstName :<form:input path="first_Name" required="true" />
		<br />
LastName :<form:input path="last_Name" required="true" />
		<br />
Contact  :<form:input path="contact" required="true" />
		<br />
UserEmail:<form:input path="user_Email" required="true" />
		<br />
UserPassword :<form:password path="user_Password" required="true" />
		<br />
ConfirmPassword:<form:password path="user_Confirm_Password"
			required="true" />
		<br />
		<input type="submit" value="Task Register" />


		<a href="login">Login</a>
	</form:form>
	<br /> ${message}
</body>
</html>