<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/static/css/style.css' />"
	rel="stylesheet">
<title>Niuv</title>
</head>
<body>
		<h1>Welcome</h1>
		
		<form action="iniciar" method="POST">
			<input type="text" placeholder="nombre" name="nombre">
			<input type="password" placeholder="password" name="password">
			<button type="submit" id="login-button">Login</button>
		</form>
		
		<a href="registro">registrate</a>
	

</body>
</html>