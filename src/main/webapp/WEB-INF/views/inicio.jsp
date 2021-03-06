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
	
<title>Inicio</title>
</head>
<body>
	<div>
		<table>
			<tr><td><img id="profileImage" src="data:image/jpeg;base64,${foto}"></td></tr>
		</table>
	</div>
	
	<form action="publicar" method="POST">
		<p>Haz una publicación</p> 
		<br/>
		<textarea rows="4" cols="50" maxlength="200" name="publicacion"></textarea>
		<br/>
		<input type="submit" value="publicar">
	</form>
	
	<br/>
	<br/>
	
		<ul>
		<c:forEach var="publ" items="${publicaciones}">
				<p><b>${usuario.nombreUsuario}</b></p>
				<br/>
				<p>${publ.contenido}</p>
				<br/>
				<p>${publ.fecha}</p>
			</c:forEach>
		</ul>
	
	
	
</body>
</html>