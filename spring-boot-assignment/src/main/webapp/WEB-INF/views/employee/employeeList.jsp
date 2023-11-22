<%@page
	import="com.valtech.training.springbootassignment.models.EmployeeModel"%>
<%@ page import="java.util.List, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>
	<%
	List<EmployeeModel> empList = (List<EmployeeModel>) request.getAttribute("employees");
	%>
	
	<div>

	<table border="1">
		<tr>
			<th>EmpId</th>
			<th>Name</th>
			<th>Age</th>
			<th>Seniority</th>
			<th>Experience</th>
			<th>Salary</th>
			<th>DeptId</th>
			<th>Actions</th>
		</tr>
		<%
		if (empList != null) {
		%>
		<%
		// Assuming 'employees' is a list of Employee objects passed from a servlet
		for (EmployeeModel e : empList) {
			request.setAttribute("e", e);
		%>
		<tr>
			<td>${e.id}</td>
			<td>${e.name}</td>
			<td>${e.age}</td>
			<td>${e.seniority}</td>
			<td>${e.experience}</td>
			<td>${e.salary}</td>
			<td>${e.deptId}</td>
			<td>
				<a href="delete?id=${e.id}">Delete</a>
				<a href="edit?id=${e.id}">Edit</a>
				<a href="view?id=${e.id}">View</a>
			</td>
		</tr>
		
		<%
		}
		%>
		<%
		}
		%>
		<tfoot>
			<tr>
				<td colspan="5" align="right">
					<form action="new" method="get">
						<input type="submit" name="submit" value="Create New Employee"/>
					</form>
				</td>
			</tr>
		</tfoot>
	</table>
		
</div>
</body>
</html>
