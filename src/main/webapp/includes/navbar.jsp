<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="index.jsp">Tienda Zuprima</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="shop.jsp">Tienda</a></li>
				<li class="nav-item"><a class="nav-link" href="cart.jsp">Carrito</a>
				</li>

				<%
				if (auth != null) {
				%>
				<li class="nav-item"><a class="nav-link" href="orders.jsp">Mis Compras</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="Log-out">Cerrar
						Sesion</a></li>
				<%
				} else {
				%>
				<li class="nav-item"><a class="nav-link" href="login.jsp">Iniciar
						Sesion</a></li>
				<%
				}
				%>


			</ul>
		</div>
	</div>
</nav>