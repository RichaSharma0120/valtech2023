<%@ page import="firstWebNEW.Department" %>
<%@ page import="firstWebNEW.Employee" %>

<%@ page import="java.util.List, java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Department dept = (Department) request.getAttribute("dept"); %>
<table>
	<tr>
		<td>ID</td>
		<td><%= dept.getDeptId()%></td>
	</tr>
	<tr>
		<td>Name</td>
		<td><%= dept.getDeptName()%></td>
	</tr>
	<tr>
		<td>Location</td>
		<td><%= dept.getDeptLoc()%></td>
	</tr>
	<tr>
		<td colspan="2">
			<form action="departmentList" method="post">
				<input type="submit" name="submit" value="First"/>
				<input type="submit" name="submit" value="Previous"/>
				<input type="submit" name="submit" value="Next"/>
				<input type="submit" name="submit" value="Last"/>
			</form>
		</td>
	</tr>
</table>

<%
	List<Employee> empList = (List<Employee>) request.getAttribute("emp");
	%>
 
 
	<table border="1">
		<tr>
			<th>Employee Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Seniority</th>
			<th>Salary</th>
		</tr>
		<%
		if (empList != null) {
		%>
		<%
		// Assuming 'employees' is a list of Employee objects passed from a servlet
		for (Employee emp1 : empList) {
		%>
		<tr>
			<td><%=emp1.getId()%></td>
			<td><%=emp1.getName()%></td>
			<td><%=emp1.getAge()%></td>
			<td><%=emp1.getSeniority()%></td>
			<td><%=emp1.getSalary()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%>

</body>
</html>