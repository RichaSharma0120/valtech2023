<!-- used to display some content like message given by the LoginServlet -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Message = <%= request.getAttribute("message") %> <br/> 
</body>
</html>