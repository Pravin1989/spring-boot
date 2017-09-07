<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
</head>
<body>	
	<form:form method="POST" action="/saveCustomerData" modelAttribute="customer">
	<h1>Wel Come to Customer Registration Page</h1>
	<div>
	<form:label path="name">Name :</form:label>
	<form:input path="name"/>
	</div>
	<div>
	<form:label path="email">Email :</form:label>
	<form:input path="email"/>
	</div>
	<div>
	<form:label path="address">Address :</form:label>
	<form:input path="address"/>
	</div>
	<div>
	<form:label path="salary">Salary :</form:label>
	<form:input path="salary"/>
	</div>
	<div>
	<input type="submit" value="Save">
	</div>
	</form:form>
</body>

</html>
