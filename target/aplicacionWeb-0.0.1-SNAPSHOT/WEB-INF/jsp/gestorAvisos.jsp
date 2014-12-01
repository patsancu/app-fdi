<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="/webstore/resource/js/controllers.js"></script>

<title>Editar avisos</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Avisos</h1>
				<h3><a href="<spring:url value="/avisos/gestor/crear"></spring:url>" >Crear nuevo aviso</a></h3>

			</div>
		</div>
	</section>

	<section class="container">
		<table class="table table-hover">
			<tr>
				<th>Título</th>
				<th>Contenido del post</th>
				<th>Tipo de aviso</th>
				<th>Etiqueta</th>
			</tr>
			<!-- <tr ng-repeat="item in cart.cartItems"> -->
			<c:forEach items="${avisos}" var="item">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="caption">
						<tr>
							<td>${item.titulo}</td>
							<td>${item.contenidoAviso}</td>
							<td>${item.tipoAviso}</td>
							<td>${item.etiqueta}</p>
							<td><a 
								href="<c:url value="/avisos/gestor/eliminar?id=${item.postInternalId}"></c:url>"
								class="btn btn-danger">Eliminar aviso</a></td>
							<td><a class="btn btn-primary">Ver aviso</a></td>
							<td><a class="btn btn-success	"> Editar aviso</a></td>

						</tr>
					</div>
				</div>
			</c:forEach>

		</table>

		<a href="<spring:url value="/" />" class="btn btn-default"> <span
			class="glyphicon-hand-left glyphicon"></span> Volver
		</a>
	</section>


</body>
</html>