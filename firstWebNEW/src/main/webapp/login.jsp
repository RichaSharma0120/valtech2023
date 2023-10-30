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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Login Page</title>

<!--  CSS Style -->
<link rel="stylesheet" href="Login.css">

</head>
<body>

	<!-- we add POST method so that our username and password remain protected -->
	<div class="loginform ">

		<h3 class="text-center fontColor">Login Here!!</h3>
		<br />

		<h4 class="text-danger text-center">
			<%
			if (null != request.getAttribute("nameMessage") || null != request.getAttribute("passMessage")) {
				out.println("Login failed");
			}
			%>
		</h4>

		<form action="login" method="post">

			<div class="form-floating mb-3">
				<input name="name" type="text" class="form-control" id="floatingInput"
					placeholder="Enter username"> <label for="floatingInput">Username
				</label>
				<div class="text-danger warning">
				<%
				if (null != request.getAttribute("nameMessage") && (request.getAttribute("nameMessage").toString().length()) <= 4) {
					out.println("Name cannot be less than 4 chars");
				}
				%>
			</div>
			</div>
			<br />
			

			<div class="form-floating">
				<input name="pass" type="password" class="form-control" id="floatingPassword"
					placeholder="Enter password"> <label for="floatingPassword">Password
				</label>
				<div class="text-danger warning">
				<%
				if (null != request.getAttribute("passMessage") && (request.getAttribute("passMessage").toString().length()) <= 4) {
					out.println("Password cannot be less than 4 chars");
				}
				%>
			</div>
			</div>
			
			<br />

			<div class="text-center d-grid gap-2">
				<button type="submit" class="btn btn-outline-primary ">Login</button>
			</div>

		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>