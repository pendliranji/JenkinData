<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
	box-sizing: border-box;
}

A {
	text-decoration: none;
}
/* Create three equal columns that floats next to each other */
.column {
	float: left;
	width: 33.33%;
	padding: 10px;
	height: 300px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}
.com{
text-align: right;
color: blue;
}
</style>
</head>
<body>

	<button id="com">
		<a align="right" href="completed">Completed</a>
	</button>
	<button>
		<a href="createtask">CreateTask</a>
	</button>
	<br />
	<br />
	<button>
		<a href="assignedToMe">Assigned Tasks to Me</a>
	</button>

	<br />
	<br />
	<button>
		<a href="assignByMe">Assigned Tasks by me</a>
	</button>
	<hr>
	<h2>Three Equal Columns</h2>

	<div class="row">
		<div class="column" style="background-color: #aaa;">
			<h2>Column 1</h2>
			<Button autofocus="autofocus">
				<a href="todo">To-Do</a>
			</Button>
		</div>
		<div class="column" style="background-color: #bbb;">
			<h2>Column 2</h2>
			<Button autofocus="autofocus" >
				<a href="inprogress">In-Progress</a>
			</Button>
		</div>
		<div class="column" style="background-color: #ccc;">
			<h2>Column 3</h2>
			<Button autofocus="autofocus">
				<a href="blocked">Blocked</a>
			</Button>
		</div>
	</div>

</body>
</html>
