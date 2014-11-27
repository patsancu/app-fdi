<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript"
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$('#myModal').modal({
		show : false,
		keyboard : false
	});
</script>

<title>Listar avisos</title>
</head>
<body>
	<%-- <section>
		<div class="jumbotron">
			<div class="container">
				<h1>Avisos</h1>
				<h4>
					<a href="<c:url value="/avisos/ver/iframe"></c:url>">Probar
						versión con iframe</a>
				</h4>
			</div>
		</div>
	</section> --%>

	<section class="container">
		<table class="table table-hover">
			<!-- <tr>
				<th>Título</th>
				<th>Contenido del aviso</th>
				<th>Tipo de aviso</th>
				<th>Etiqueta</th>
			</tr> -->
			<!-- <tr ng-repeat="item in cart.cartItems"> -->
			<c:forEach items="${avisos}" var="item">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="caption">
						<tr>
							<td>${item.titulo}</td>
							<td>${item.contenidoAviso}</td>
							<td>${item.tipoAviso}</td>
							<td>${item.etiqueta}</p>
							<td><a class="btn btn-success"
								href="<c:url value="/avisos/gestor/editar?id=${item.postInternalId}"></c:url>">
									<span class="glyphicon glyphicon-edit"></span>
							</a></td>
							<td><a
								href="<c:url value="/avisos/ver/individual?id=${item.postInternalId}"></c:url>"
								class="btn btn-primary"> <span
									class="glyphicon glyphicon-info-sign"></span>
							</a></td>
							<td>
								<!-- Botón eliminar -->
								<button type="button" class="btn btn-danger" data-toggle="modal"
									data-target=".bs-delete-modal-sm${item.postInternalId}">
									<span class="glyphicon glyphicon-remove"></span>
								</button>
								
								<!-- Popup de confirmación de eliminación -->
								<div
									class="modal fade bs-delete-modal-sm${item.postInternalId}"
									tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
									aria-hidden="true">
									<div class="modal-dialog modal-sm">
										<div class="modal-content">
											<div class="modal-header bg-primary">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
												<h4 class="modal-title" id="myModalLabel">Eliminar
													aviso</h4>
											</div>
											<div class="modal-body">¿Está seguro de que desea
												eliminar el aviso "${item.titulo}"?</div>
											<div class="modal-footer ">
												<a class="btn btn-danger "
													href="<c:url value="/avisos/gestor/eliminar?id=${item.postInternalId}"></c:url>">
													Eliminar </a>
												<button type="button" class="btn btn-warning "
													data-dismiss="modal">Cancelar</button>
											</div>
										</div>
									</div>
								</div> <!-- Fin de  Popup de confirmación de eliminación -->
							</td>
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