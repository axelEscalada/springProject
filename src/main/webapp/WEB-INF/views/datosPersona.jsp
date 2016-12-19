<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Ingresa tus datos personales para terminar con el registro</h1>
	<form action="registrarPersona" method=POST>
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
		<input type="submit" value="guardar"/>
	</form>
</body>
</html>