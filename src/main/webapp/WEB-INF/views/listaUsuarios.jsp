<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Administrador ${nombre} </h1>
	<h2>Usuarios : </h2>
	
		<ul>
			<c:forEach var="user" items="${usuarios}">
				<li>${user}
					<a href="<spring:url value="/users/${user.id}" /> ">
					Ver perfil
					</a>
					<a href="<spring:url value="/managed/${user.id}" /> ">
					Editar
					</a>
				</li>
			</c:forEach>
		</ul>
		
	<a href="principal">Inicio</a>	
	<a href="logout">Logout</a>

	
</body>
</html>