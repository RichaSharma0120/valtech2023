<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
<div class="container result-container">
        <h1 class="title">Result</h1>
        <p class="result-text">The result is: <%= request.getAttribute("result") %></p>
        <p class="result-text">In Decimal: <%= request.getAttribute("decimalResult") %></p>
        <a href="numberSystem.jsp" class="btn btn-secondary">Go Back</a>
    </div>
</body>
</html>