<%@page import="com.chema.servlets.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>
<link href="./css/style.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="./header.jsp"></jsp:include>

	<h1>Datos de Usuario</h1>

	<ul>
		<li>Id: ${requestScope.elUsuario.id}</li>
		<li>Nombre: ${elUsuario.name}</li>
		<li>Email: ${elUsuario.email}</li>
		<li>Habitación: <a
			href="./habitacion?id=${elUsuario.habitacion.hid}">${requestScope.elUsuario.habitacion}</a></li>
	</ul>

<button id="volverBtn">Volver</button>

</body>

<script src="./js/script.js"></script>

</html>