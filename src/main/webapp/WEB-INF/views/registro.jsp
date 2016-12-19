<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrate en Niuv</title>
</head>
<body>

	<h1>¡Registrate en nuestra página!</h1>
	
	<form action="registrar" method="POST">
		<label>Usuario:</label>
		<input type="text" name="nombre" required=required/>
		<label>Contraseña:</label>
		<input type="password" name="password" required=required/>
		<input type="submit" value="registrar"/>
	</form>

</body>
</html>