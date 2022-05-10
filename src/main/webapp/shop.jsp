
<%@page import="java.util.List"%>
<%@page import="cn.dweb.dao.ProductoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
ProductoDao pd = new ProductoDao(DbConnect.getConnection());
List<Producto> prods = pd.getAllProducts();
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/head.jsp"%>
</head>

<body>
	<%@include file="includes/navbar.jsp"%>
	<div class="container">
		<div class="card-header my-3">Todos los Productos</div>
		<div class="row">
			<%
			if (!prods.isEmpty()) {
				for (Producto p:prods) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100" style="width: 18rem;">
					<img src="ImgProds/<%=p.getImage()%>" class="card-img-top"
						alt="...">
					<div class="card-body">
						<h5 class="card-title"><%=p.getName()%></h5>
						<h6 class="price">
							Precio:
							<%=p.getPrice()%></h6>
						<h6 class="category">
							Categoria:
							<%=p.getCategory()%></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a href="#" class="btn btn-primary me-2">Agregar al Carrito</a> <a
								href="#" class="btn btn-success">Comprar Ahora</a>
						</div>
					</div>
				</div>
			</div>
			<%}
			} else {
			out.println("There is no proucts");
			}
			%>

		</div>
	</div>
</body>
</html>