<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<STYLE>
A {
	text-decoration: none;
}
</STYLE>

</head>

<br/>
${created}
<jsp:forward page="DashBoard.jsp"></jsp:forward>
<body>
	<h1>Welcome to task Management system Dash board</h1>
	<button>
		<a href="createtask">CreateTask</a>
	</button>
	<br/>
	<br/>
	<button>
		<a href="assignedToMe">Assigned Tasks to Me</a>
	</button>

<br/><br/>
	<button>
		<a href="assignByMe">Assigned Tasks by me</a>
	</button>
	<br/><br/>
	<button>
		<a href="todo">TO DO</a>
	</button>
<br/><br/>
	<button>
		<a href="inprogress">InProgress</a>
	</button>
	<br/><br/>
	<button>
		<a href="completed">Completed</a>
	</button>
	<br/><br/>
	<button>
		<a href="blocked">Blocked</a>
	</button>
</body>
</html>