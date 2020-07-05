<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.css" />
</head>
<body>
	<div class="container">
		<h1>List Employees</h1>
		<p>${message }</p>
		
		<button class="btn btn-primary" onclick="window.location.href='views/employee-add.jsp'">Add Employee</button>
		<table border="1" class="table table-striped table-bordered">
			<tr class="thead-dark">
				<th>Name</th>
				<th>DOB</th>
				<th>Department</th>
				<th>Actions</th>
			</tr>

			<c:forEach items="${list}" var="employee">

			<tr>
				<td>${employee.name}</td>
				<td>${employee.dob}</td>
				<td>${employee.department}</td>
				<td>
				<a href="${pageContext.request.contextPath}/EmployeeController?action=EDIT&id=${employee.id}">Edit</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>