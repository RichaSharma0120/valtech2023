<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2 style="color: red">${message}</h2>
	<form action="register" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><input name="username" type="text" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input name="password" type="password" /></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input name="confirmPassword" type="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input name="submit" type="submit"
					value="Register" /></td>
			</tr>
		</table>
	</form>
</body>
</html>