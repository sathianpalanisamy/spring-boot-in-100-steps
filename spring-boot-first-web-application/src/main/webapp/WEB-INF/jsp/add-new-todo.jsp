<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Add to do page for ${name}</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker3.min.css"
	rel="stylesheet"></link>
</head>
<body>
	<div class="container">
		<form:form method="post" modelAttribute="todo">
			<form:hidden path="id" />
			<fieldset class="form-group">
				<form:label path="desc">Description </form:label>
				<form:input type="text" path="desc" class="form-control"
					required="required" />
				<form:errors path="desc" cssClass="text-warning"></form:errors>
			</fieldset>
			<fieldset class="form-group">
				<form:label path="targetDate">Target Date </form:label>
				<form:input type="text" path="targetDate" class="form-control"
					required="required" />
				<form:errors path="targetDate" cssClass="text-warning"></form:errors>
			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
		
		<script type="text/javascript">
		$('#targetDate').datepicker({
		format:'dd/mm/yyyy'
		})
		
		</script>
</body>
</html>