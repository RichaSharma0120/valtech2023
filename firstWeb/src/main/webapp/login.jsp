<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Login Page</title>

<!--  CSS Style -->
<link rel="stylesheet" href="Login.css">
	
</head>
<body>
<!-- decorate with bootstrap/tailwind -->
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


<!-- we add POST method so that our username and password remain protected -->
<div class="loginform">

	<h3 class="text-center fontColor">Login Here!!</h3>
	<form action="login" method="post">
		Name :  <br/> 
		<input name="name" type="text" placeholder="Enter username" style="width:100%" class="inputBox"/> <br/>
		Password :  <br/>
		<input name="pass" type="password" placeholder="Enter password" style="width:100%" class="inputBox"/> <br/>
		<input name="submit" type="submit" value="login" style="margin : 25px 5px;" class="loginButton"/>
</form>
</div>

</body>
</html>