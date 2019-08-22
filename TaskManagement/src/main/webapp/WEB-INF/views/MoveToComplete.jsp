<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="complete" modelAttribute="progress" method="POST">
Id       :<form:input path="id" readonly="true"/>
<br/>
Description : <form:textarea path="description" readonly="true"/>
		<br />
		<br />
Assign To : <form:input path="assignTo" readonly="true"/>
		<br />

		<br />
End Date : <form:input path="date" type="date" readonly="true"/>
		<br />
Category : <form:select path="category" readonly="true">
			<form:option value="NONE" label="Select" />
			<form:option value="JAVA">java</form:option>
			<form:option value="ASP">Asp</form:option>
		</form:select>
		<br />
Add Category : <form:input path="addCategory" readonly="true"/>
		<br />
Priority     : <form:select path="priority" readonly="true">
			<form:option value="NONE" label="Select" />
			<form:option value="LOW" readonly="true">low</form:option>
			<form:option value="HIGH" readonly="true">High</form:option>
			<form:option value="NORMAL" readonly="true">normal</form:option>
			<form:option value="CRITICAL" readonly="true">critical</form:option>
		</form:select>
		<br />

Email  :<form:input path="email" readonly="true"/>
		<br />
		<input type="submit" value="MoveToCompleted" />
	</form:form>

</body>
</html>