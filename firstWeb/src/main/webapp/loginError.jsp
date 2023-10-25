<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Login Here!!</title>

</head>
<body>
<!-- decorate with bootstrap/tailwind -->
<!-- we add POST method so that our username and password remain protected -->
<div >
	<p>Login Failed</p> <br/><br/>

	<form action="login" method="post" class="loginform">
	Name : <input name="name" type="text"/> <br/> 
	<div style="color:red"><%= request.getAttribute("nameMessage") %></div> <br/>

	Password : <input name="pass" type="password"/> <br/> 
	<div style="color:red"><%= request.getAttribute("passMessage") %></div> <br/>
	
	<input name="submit" type="submit" value="login"/>

</form>
</div>
</body>
</html>