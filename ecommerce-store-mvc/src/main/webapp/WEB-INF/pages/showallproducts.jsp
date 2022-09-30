<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style type="text/css">
table, tr, td, th {
	border: 2px solid blue;
	margin-left: auto;
	margin-right: auto;
	border-collapse: collapse;
}
</style>
</head>
<body>

	<div>

		<table>
			<thead>
				<tr>
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Product Inventory</th>
					<th>Product Merchant</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="eachProduct">
					<tr>
						<td>${eachProduct.productId}</td>
						<td>${eachProduct.productName}</td>
						<td>${eachProduct.productPrice}</td>
						<td>${eachProduct.productInventory}</td>
						<td>${eachProduct.productMerchant}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>
	<br> <br>
	<div style="text-align: center;">
			<button onclick="window.location.href='/product-home'"
			class="btn btn-danger">Product Home page</button>
	</div>
	<div style="margin: 50px;text-align: center">
	<a href="/" class="btn btn-warning">Go to Welcome Page</a>
	</div>
</body>
</html>