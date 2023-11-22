<%@page
	import="com.valtech.training.springbootassignment.models.EmployeeModel"%>
<%@page
	import="com.valtech.training.springbootassignment.models.DepartmentModel"%>

<%@ page import="java.util.List, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
	<h1 class="fw-medium">Department Information</h1></br>
	<%
	DepartmentModel dept = (DepartmentModel) request.getAttribute("department");
	request.setAttribute("dept", dept);
	%>
	<table>
		<tr>
			<td>ID</td>
			<td>${dept.id}</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${dept.deptName}</td>
		</tr>
		<tr>
			<td>Location</td>
			<td>${dept.deptLoc}</td>
		</tr>
	</table>
	<form action="">
		<a class="link-opacity-25-hover" href="first?id=${dept.id}">First</a>&nbsp;&nbsp;
		<a class="link-opacity-25-hover" href="next?id=${dept.id}">Next</a>&nbsp;&nbsp;
		<a class="link-opacity-25-hover" href="previous?id=${dept.id}">Previous</a>&nbsp;&nbsp;
		<a class="link-opacity-25-hover" href="last?id=${dept.id}">Last</a>&nbsp;&nbsp;
	</form></br></br>


	<%
	List<EmployeeModel> empList = (List<EmployeeModel>) request.getAttribute("employees");
	%>
	<h3 class="fw-medium">Employees in department : ${dept.deptName}</h3></br>

	<table border="1" class="table-info">
		<tr>
			<th>Employee Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Seniority</th>
			<th>Experience</th>
			<th>Salary</th>
		</tr>
		
		<%
		for (EmployeeModel emp1 : empList) {
			request.setAttribute("emp1", emp1);
		%>
		<tr>
			<td>${emp1.id}</td>
			<td>${emp1.name}</td>
			<td>${emp1.age}</td>
			<td>${emp1.seniority}</td>
			<td>${emp1.experience}</td>
			<td>${emp1.salary}</td>
		</tr>
		<%
		}
		%>
	</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>