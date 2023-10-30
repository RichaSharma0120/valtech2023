<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="employeeList" method="post">
        <label for="empId">Emp ID:</label>
        <input type="text" id="empId" name="empId" required><br>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="age">Age:</label>
        <input type="text" id="age" name="age" required><br>

        <label for="seniority">Seniority:</label>
        <input type="text" id="seniority" name="seniority" required><br>

        <label for="salary">Salary:</label>
        <input type="text" id="salary" name="salary" required><br>

        <label for="experience">Experience:</label>
        <input type="text" id="experience" name="experience" required><br>

        <label for="deptId">Dept ID:</label>
        <input type="text" id="deptId" name="deptId" required><br>

        <input type="submit" value="Submit" name="submit">
    </form>
</body>
</html>