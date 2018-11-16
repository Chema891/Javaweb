
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="./css/style.css" rel="stylesheet">
</head>
<body>

	<h1>Login</h1>
	<div class="error">${errormensaje}</div>
	<form action="" method="POST">
		<div>
			<input type="email" placeholder="email" name="email" id="email" />
		</div>
		<div>
			<input type="password" placeholder="password" name="password" id="password" />
		</div>
		<div><button>Entrar</button> </div>
	</form>

</body>
</html>