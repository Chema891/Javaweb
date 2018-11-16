<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Usuario</title>
<link href="./css/style.css" rel="stylesheet">
</head>
<body>

	<h1>DATE DE ALTA</h1>

	<form action="" method="POST">
		<div class="error">${mensajeerror}</div>

		<div>
			<input type="text" placeholder="Nombre" name="name" id="name"
				value="${nuevousuario.name}" />
		</div>
		<div>
			<input type="email" placeholder="email" name="email" id="email"
				value="${nuevousuario.email}" />
		</div>
		<div>
			<input type="password" placeholder="contraseña" name="password"
				value="" id="password" />
		</div>
		<div>
			<input type="password" placeholder="confirma contraseña"
				name="confirmarpassword" id="confirmarpassword" />
		</div>
		<div>
			<label for="habitacion">Habitación:</label> 	
			<select name="habitacion" id="habitacion">
				<c:forEach var="unaHab" items="${lasHabitaciones}">
					<option value="${unaHab.hid}">${unaHab.streat}</option>
				</c:forEach>
			</select>
		</div>
		<div>
		 <a href="./nuevahabitacion">Nueva Habitacion</a>
		</div>
		<div>
			<button>Registrarse</button>
		</div>
	</form>

</body>
</html>