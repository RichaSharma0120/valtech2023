<%@ page import="java.util.List, java.util.ArrayList"%>
<%@page import="com.valtech.training.springbootassignment.models.EmployeeModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view employee</title>
</head>
<body>
<h3>We are viewing an employee details</h3>

	<%
	EmployeeModel e =(EmployeeModel) request.getAttribute("employees");
	request.setAttribute("e", e);
	
	%>
	<form action="employeeList" method="get">
		<table>
	<tr>
		<td>ID</td>
		<td>${e.id}</td>
	</tr>
	<tr>
		<td>Name</td>
		<td>${e.name}</td>
	</tr>
	<tr>
		<td>Age</td>
		<td>${e.age}</td>
	</tr>
	<tr>
		<td>Seniority</td>
		<td>${e.seniority}</td>
	</tr>
	<tr>
		<td>Experience</td>
		<td>${e.experience}</td>
	</tr>
	<tr>
		<td>Salary</td>
		<td>${e.salary}</td>
	</tr>
		<tr>
		<td>Dept Id</td>
		<td>${e.deptId}</td>
	</tr>

	
	<tr>
		<td colspan="2">
			<input type="submit" name="cancel" value="Cancel" />
		</td>
	</tr>
			
	</table>
	</form>
</body>
</html>