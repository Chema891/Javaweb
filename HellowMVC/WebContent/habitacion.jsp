<%@page import="com.chema.servlets.Habitacion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Habitacion</title>
<link href="./css/style.css" rel="stylesheet">
</head>
<body>

	<jsp:include page="./header.jsp"></jsp:include>


	<h1>Datos de Habitacion</h1>

	<ul>
		<li>hid: ${requestScope.laHabitacion.hid}</li>
		<li>calle: ${requestScope.laHabitacion.streat}</li>
		<li>Numero: ${requestScope.laHabitacion.number}</li>
		<li>ciudad: ${requestScope.laHabitacion.city}</li>
	</ul>

<button id="volverBtn">Volver</button>


</body>

<script src="./js/script.js"></script>

</html>