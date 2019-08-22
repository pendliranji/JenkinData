<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="create" modelAttribute="create" method="POST">
Description : <form:textarea path="description" />
		<br />   
		
		<br />
Assign To : <form:input path="assignTo" />
		<br />

		<br />
End Date : <form:input path="date" type="date" />
		<br />
Category : <form:select path="category">
			<form:option value="NONE" label="Select" />
			<form:option value="JAVA">java</form:option>
			<form:option value="ASP">Asp</form:option>
		</form:select>
		<br />
Add Category : <form:input path="addCategory" />
		<br />
Priority     : <form:select path="priority">
			<form:option value="NONE" label="Select" />
			<form:option value="LOW">low</form:option>
			<form:option value="HIGH">High</form:option>
			<form:option value="NORMAL">normal</form:option>
			<form:option value="CRITICAL">critical</form:option>
		</form:select>
		<br />

Email  :<form:input path="email" />
		<br />
		<input type="submit" value="Save&Assign" />
	</form:form>
</body>
</html>