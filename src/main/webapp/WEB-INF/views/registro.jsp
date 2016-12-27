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
<title>Registro</title>
</head>
<body>

	<h1>¡Registrate en nuestra página!</h1>

	<form method="post" action="registrar">
		<label>Nombre</label>
		<input name="nombre" type="text" />
		<label>Contraseña</label>
		<input name="password" type="password" />
		<input type="submit" value="registrar"/>
	</form>
	
	<c:if test="${not empty error}">
	   <p style="color: red">${error}</p>
	</c:if>
	
	<a href="login">Login</a>

</body>
</html>