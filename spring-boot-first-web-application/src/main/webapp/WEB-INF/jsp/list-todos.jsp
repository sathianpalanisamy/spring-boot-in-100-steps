<%@include file="commons/header.jspf"%>
<%@include file="commons/navigation.jspf"%>
<div class="container">
	<table class="table table-striped">
		<caption>your todo's</caption>
		<thead>
			<tr>
				<td>Description</td>
				<td>Target Date</td>
				<td>Is It Done?</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="item">
				<tr>
					<td>${item.desc}</td>
					<td><fmt:formatDate value="${item.targetDate}"
							pattern="dd/MM/yyyy" /></td>
					<td>${item.done}</td>
					<td><a type="button" class="btn btn-success"
						href="update-todo?id=${item.id}">Update</a></td>
					<td><a type="button" class="btn btn-warning"
						href="delete-todo?id=${item.id}">Delete</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<div>
		<a class="button" href="add-new-todo">Add New Todo</a>
	</div>
</div>
<%@include file="commons/footer.jspf"%>