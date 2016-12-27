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

	<h1>ˇBienvenido a Niuv ${usuario.nombreUsuario}!</h1>
	
	<a href="datos">Ingresar datos personales</a>
	
	<a href="lista">Lista de usuarios</a>
	
	<a href="principal">Inicio</a>
	
	<a href="logout">Logout</a>
	
	

</body>
</html>