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
	<h1>Ingresa tus datos personales para terminar con el registro</h1>
	<form action="registrarPersona" enctype="multipart/form-data" method=POST>
		<label>Nombre:</label>
		<input type="text" name="nombre" required=required/>
		<br/>
		<label>Apellido:</label>
		<input type="text" name="apellido" required=required/>
		<br/>
		<label>Fecha de nacimiento:</label>		
			<input type="date" name="fecha" required=required/>
		<br/>
		<label>Trabajo/Ocupación:</label>		
			<input type="text" name="trabajo" />
		<br/>
	    <label>File to upload:</label><input type="file" name="file" />

		<input type="submit" value="guardar"/>
	</form>
</body>
</html>