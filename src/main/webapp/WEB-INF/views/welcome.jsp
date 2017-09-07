<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="/static/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/bootstrap.min.css"/>" media="all" />
<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/bootstrap.min.css"/>" media="all" />
<script src="/assets/css/bootstrap.min.js"></script>
<script src="/assets/css/jquery.min.js"></script>
<!-- <link rel="stylesheet" href="/css/bootstrap.min.css"/>
<script src="css/jquery.min.js"></script>
 <script src="/static/css/bootstrap.min.js"></script> -->
</head>
<body>	
<h3>Wel Come to Home Page</h3>
	<a class="btn btn-default" href="/createCustomer">Create Customer</a><br>
	<a class="btn btn-default" href="/listCustomers">List the Customer Details</a>
	 <button class="btn btn-default" type="button">
            <span class="glyphicon glyphicon-search">Get It</span>
          </button>
</body>
</html>
