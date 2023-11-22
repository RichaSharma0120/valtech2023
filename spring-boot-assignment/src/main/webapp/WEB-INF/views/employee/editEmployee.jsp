<%@page import="com.valtech.training.springbootassignment.models.EmployeeModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%EmployeeModel e = (EmployeeModel) request.getAttribute("employees"); %>
	<form method="post" action="save?id=<%= e.getId()%>">
		<table>
			<tr>
				<td>Id</td>
				<td><input type="text" name="id" disabled="disabled" value="<%= e.getId()%>"/></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value="<%= e.getName()%>"/></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age" value="<%= e.getAge()%>"/></td>
			</tr>
			<tr>
				<td>Seniority</td>
				<td><input type="text" name="seniority" value="<%= e.getSeniority()%>"/></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" name="salary" value="<%= e.getSalary()%>"/></td>
			</tr>
			<tr>
				<td>Experience</td>
				<td><input type="text" name="experience" value="<%= e.getExperience()%>"/></td>
			</tr>
			<tr>
				<td>Dept Id</td>
				<td><input type="text" name="deptId" value="<%= e.getDeptId()%>"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" name="submit" value="Update" /> 
					<input type="submit" name="cancel" value="Cancel" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>