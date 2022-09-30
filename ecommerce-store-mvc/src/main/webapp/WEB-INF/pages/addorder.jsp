<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add and update Order</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<p style="color: #00FF00">${message}</p>
	<form:form method="post" modelAttribute="order" action="saveOrder">
		<div class="form-group">
			<label>Order Id</label>
			<form:input path="orderId" class="form-control" id="orderId"
				required="required" />
		</div>
		<div class="form-group">
			<label>User</label>
			<form:input path="user" class="form-control" id="user" />
		</div>
		<div class="form-group">
			<label>Order Date</label>
			<form:input path="orderDate" class="form-control" id="orderDate" />
		</div>
		<div class="form-group">
			<label>Product Id</label>
			<form:input path="product" class="form-control" id="product" />
		</div>
		<div class="form-group">
			<input type="submit" value="Add"> <input type="submit"
				value="Update" formaction="saveOrder">
		</div>
	</form:form>
	<div>
		<button onclick="window.location.href='order-home'"
			class="btn btn-danger">Order Home page</button>
	</div>
</body>
</html>