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
</head>
<body>
	<c:set var="au" value="${requestScope['autor']}" />
	<c:set var="lib" value="${requestScope['libro']}" />
	<div>

		<div id="header">


			<!-- Nav -->
			<nav id="nav">
				<ul>
					<li><a href="index.html">Home</a></li>
					<li><a href="/Correccion_Exam/Paginas/listarLibros.jsp">Listar Libros</a></li>
					<li><a href="/Correccion_Exam/Paginas/RegistrarLibro.jsp">Ingresar
							Libro</a></li>

				</ul>
			</nav>


		</div>
	</div>
	<br>



	<div class="cuerpo">
		<div class="contenedor">
			<form action="/Correccion_Exam/IngresarCapitulo" method="POST"
				>
				<div class="container">
					<p>Ingresar Libro.</p>
					<hr>

					<label for="nombres"><b>Nombre</b></label> <input id="nombresID"
						type="text" value="${lib.nombre}" placeholder="Ingresar nombre libro" name="nombre"
						 required><span
						id="mensajeNombres"></span> <label for="apellidos"><b>ISBN</b></label>
					<input id="apellidosID" value="${lib.ISBN}" type="text" placeholder="Ingresar ISBN"
						name="ISBN"
						
						required><span id="mensajeApellidos"></span> <label
						for="cedula"><b>Numero paginas</b></label> <input id="cedulaID"
						type="text" value="${lib.numPaginas}" placeholder="Ingresar numero paginas"
						name="numPaginas"
						onkeypress="ValidarNumeros(event, 'mensajeCedula', this)" required>
					<span id="mensajeCedula"></span>

					<button type="submit" class="registerbtn" name="registrarLibro"
						value="Registrar">Registrar</button>
				</div>

				<div class="container">
					<p>Agregar Capitulo</p>
					<hr>

					<label for="nombres"><b>Titulo</b></label> <input id="nombresID"
						type="text" placeholder="Ingresar nombre capitulo" name="titulo"
						onkeypress="ValidarLetras(event, 'mensajeNombres', this)" ><span
						id="mensajeNombres"></span> <label for="cedula"><b>Numero</b></label> <input id="cedulaID" type="text"
						placeholder="Ingresar numero capitulo" name="numCap"
						onkeypress="ValidarNumeros(event, 'mensajeCedula', this)" >
					<span id="mensajeCedula"></span> <label for="tipo"><b>Autor</b></label>
					<div class="container mt-3">
						<select name="tip" id="seleccion" class="custom-select mb-3">
							<option selected>Seleccionar</option>
							<c:forEach var="autor" items="${au}">
								<option>${autor.nombre}</option>
							</c:forEach>
						</select>
					</div>

					<button type="submit" class="agregarCap" name="registrarLibro"
						value="Agregar">Agregar</button>
				</div>

			</form>

		</div>

	</div>

</body>
</html>