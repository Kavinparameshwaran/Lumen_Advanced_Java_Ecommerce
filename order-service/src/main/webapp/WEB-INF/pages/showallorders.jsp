<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<style type="text/css">

table,tr,td,th{

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
						<th>Order Id</th>
						<th>User</th>
						<th>Order Date</th>
						<th>Product Details</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="eachOrder">
						<tr>
							<td>${eachOrder.orderId}</td>
							<td>${eachOrder.user}</td>
							<td>${eachOrder.orderDate}</td>
							<td>${eachOrder.productDetails}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

</body>
</html>