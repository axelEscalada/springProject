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
<title>Insert title here</title>
</head>
<body>

	<form action="actualizar/${id}" method="POST">
		<label>Usuario:</label>
		<input type="text" name="nombre" required=required" value="${usuario.nombreUsuario}"/>
		<label>Contraseña:</label>
		<input type="text" name="password" required=required />
		<input type="submit" value="Actualizar"/>
	</form>
	<form action="borrar/${id}" method="POST">
		<input type="submit" value="Borrar">
	</form>
	
	

</body>
</html>