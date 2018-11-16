<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Habitación</title>
<link href="./css/style.css" rel="stylesheet">
</head>

<body>

<h1>NUEVA HABITACION</h1>

    	<form action="" method="POST">
		<div class="error">${mensajeerror}</div>

		<div>
			<input type="text" placeholder="Calle" name="calle" id="calle"
				value="${nuevohabitacion.calle}" />
		</div>
		<div>
			<input type="number" placeholder="Número" name="numero" id="numero"
				value="${nuevohabitacion.numero}" />
		</div>
		<div>
			<input type="text" placeholder="Ciudad" name="ciudad" id="ciudad"	value="${nuevohabitacion.ciudad}"  />
		</div>
		
		<div>
			<button>Dar de Alta</button>
		</div>
	</form>


</body>
</html>