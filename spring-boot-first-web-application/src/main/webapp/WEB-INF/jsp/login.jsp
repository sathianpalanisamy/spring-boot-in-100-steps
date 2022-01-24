<%@include file="commons/header.jspf"%>
<%@include file="commons/navigation.jspf"%>
<div class="container">
	<font color="red">${errorMessage }</font>
	<form:form method="post" modelAttribute="login">
		<fieldset class="form-group">
			<form:label path="name">Name </form:label>
			<form:input type="text" path="name" class="form-control"
				required="required" />
		</fieldset>
		<fieldset>
			<form:label path="pass">Password </form:label>
			<form:input type="password" path="pass" class="form-control"
				required="required" />
		</fieldset>
		<br/>
		<button type="submit" class="btn btn-success"> login</button>
	</form:form>
</div>
<%@include file="commons/footer.jspf"%>