<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
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

	<div class="container col-6" >
	<p>${message }</p>
	<form action="${pageContext.request.contextPath}/EmployeeController" method="post">
	Enter name : <input type ="text" name="firstname"><br>
	Enter DOB : <input type ="date" name="dob"><br>
	Enter Department : <input type ="text" name="department"><br>
	
	<button class="btn btn-primary" type="submit">Submit</button>
	</form>
	
	</div>
	

</body>
</html>