<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
			<label>Nombre</label>
			<input type="text" placeholder="nombre" name="nombre">
			<label>Contrase�a</label>
			<input type="password" placeholder="password" name="password">
			<button type="submit" id="login-button">Login</button>
		</form>
		
		<c:if test="${not empty error}">
		   <p style="color: red">${error}</p>
		</c:if>
		
		<a href="registro">Registrate</a>
	

</body>
</html>