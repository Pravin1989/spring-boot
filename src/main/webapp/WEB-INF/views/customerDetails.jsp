<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Customer Details :</h2>

	<c:if test="${not empty customers}">
		<table>
			<tr>
				<th>Customer Id</th>
				<th>Customer Name</th>
				<th>Customer Email</th>
				<th>Customer Address</th>
				<th>Customer Salary</th>
			</tr>

			<c:forEach var="customer" items="${customers}">
				<tr>
					<td>${customer.customer_id}</td>
					<td>${customer.name}</td>
					<td>${customer.email}</td>
					<td>${customer.address}</td>
					<td>${customer.salary}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>