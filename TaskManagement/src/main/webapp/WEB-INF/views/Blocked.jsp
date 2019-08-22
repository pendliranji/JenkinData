<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<c:choose>
		<c:when test="${blocked[0]!=null}">
			<table border="1 ">
				<tr>
					<th>ID</th>
					<th>description</th>
					<th>assign to</th>
					<th>End-date</th>
					<th>Category</th>
					<th>Priority</th>

				</tr>
				<c:forEach var="stu" items="${blocked}">
					<tr>
						<td><c:out value="${stu.id}"></c:out></td>
						<td><c:out value="${stu.description}"></c:out></td>
						<td><c:out value="${stu.assignTo}"></c:out></td>
						<td><c:out value="${stu.date}"></c:out></td>
						<td><c:out value="${stu.category}"></c:out></td>
						<td><c:out value="${stu.priority}"></c:out></td>


					</tr>
				</c:forEach>
				</c:when>
				<c:otherwise>
					<c:out value="No Data Found in Database" />
				</c:otherwise>
				</c:choose>
</body>
</html>