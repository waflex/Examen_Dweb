<%@page import="cn.dweb.database.DbConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="includes/head.jsp"%>
</head>

<body>
	<%@include file="includes/navbar.jsp"%>
	<div class="container">
		<div class="card-header my-3">Todos los Productos</div>
		<div class="row">
			<div class="col-md-3">
				<div class="card w-100" style="width: 18rem;">
					<img src="ImgProds/Pantalon2.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<h6 class="price">Precio: $15.000</h6>
						<h6 class="category">Categoria: algo</h6>
						<div class="mt-3 d-flex justify-content-between">
							<a href="#" class="btn btn-primary me-2">Agregar al Carrito</a>
							<a href="#" class="btn btn-success">Comprar Ahora</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>