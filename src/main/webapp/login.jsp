<%@page import="cn.dweb.database.DbConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
<%@include file="includes/head.jsp"%>
</head>
<%
if (auth != null)
	response.sendRedirect("index.jsp");
%>
<body>
	<%@include file="includes/navbar.jsp"%>
	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">
				<h4>Inicio Sesion</h4>
			</div>
			<div class="card-body">
				<form action="user-login" method="post">
					<div class="mb-3">
						<label class="form-label">Nombre Usuario</label> <input
							type="text" class="form-control" name="correo"
							placeholder="correo@correo.com">
					</div>
					<div class="mb-3">
						<label class="form-label">Contraseña</label> <input
							type="password" class="form-control" name="password"
							placeholder="******">
					</div>
					<div class="text-center">
						<button type="submit" class="btn btn-primary">Ingresar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>

</html>