<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Todo's For ${name}</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<caption>your todos</caption>
			<thead>
				<tr>
					<td>Description</td>
					<td>Target Date</td>
					<td>Is It Done?</td>
					<td>Delete</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="item">
					<tr>
						<td>${item.desc}</td>
						<td>${item.targetDate}</td>
						<td>${item.done}</td>
						<td><a type="button" class="btn btn-warning" href="delete-todo?id=${item.id}">Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

		<div><a class="button" href="add-new-todo">Add New Todo</a></div>

		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>
</html>