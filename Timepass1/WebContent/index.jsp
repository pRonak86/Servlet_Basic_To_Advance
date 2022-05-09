<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="post">	
		<table>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="uname"></td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td><input type="password" name="psw"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>