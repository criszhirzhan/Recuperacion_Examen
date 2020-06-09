<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="/Correccion_Exam/config/styles/stylesCrUser.css">
<script type="text/javascript"
	src="/Correccion_Exam/config/JS/validaciones.js"></script>
<link rel="stylesheet" href="/Correccion_Exam/config/styles/main.css" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>	
</head>
<body>
	<c:set var="lib" value="${requestScope['capitulos']}" />
<div id="header">

		<div class="top">

			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="/Correccion_Exam/IndexController?id=1" id="contact-link"><span
							class="icon solid fa-envelope">Listar Libro</span></a></li>
					<li><a href="/Correccion_Exam/IndexController?id=4" id="top-link"><span
							class="icon solid fa-home">Registrar Libro</span></a></li>
				</ul>
			</nav>

		</div>

	</div>
	
	<div id="main">


		<!-- Contact -->
		<section id="contact" class="four">
			<div class="container">
				<div class="container mt-3">



					<form action="/Correccion_Exam/IndexController?id=2" method="POST">
						<div class="input-group mb-3 input-group-sm">
							<div class="input-group-prepend">
								<button class="input-group-text" name="buscarAutor"
									value="autornom" type="submit">Buscar</button>

							</div>
							<input type="text" class="form-control" name="autor"
								placeholder="Buscar por nombre autor....">
						</div>
					</form>




					<form action="/Correccion_Exam/IndexController?id=3" method="POST">
						<div class="input-group mb-3 input-group-sm">
							<div class="input-group-prepend">
								<button class="input-group-text" name="buscarTitulo"
									value="titulo" type="submit">Buscar</button>

							</div>
							<input type="text" class="form-control" name="titulo"
								placeholder="Buscar por titulo ....">
						</div>
					</form>
					<br>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Libro</th>
								<th>Capitulos</th>
								<th>Autor</th>
							
							</tr>
						</thead>
						<tbody id="myTable">

							<c:forEach var="cap" items="${capitulos}">
								<tr>
									<td>${cap.libro.nombre}</td>
									<td>${cap.titulo}</td>
									<td>${cap.autor.nombre}</td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</section>

	</div>




</body>
</html>