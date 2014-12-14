<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript">
	$('#myModal').modal({
		show : false,
		keyboard : false
	});
</script>



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
						<td><c:if test="${item.tipoAviso eq 'Importante'}">
								<span class=" glyphicon glyphicon-exclamation-sign"></span>
							</c:if></td>
						<td>${item.titulo}</td>
						<td>${fn:substring(item.contenidoAviso, 0, 25)} ...</td>
						<td>${item.tipoAviso}</td>
						<td>${item.etiqueta}</p>
						<td>Creado el ${fn:substring(item.fechaCreacion,0,19	)}
							</p>
						<td>Publicacion: ${fn:substring(item.fechaPublicacion,0,19	)}
							</p>
						<td><a class="btn btn-success"
							href="<c:url value="/avisos/gestor/editar?id=${item.postInternalId}"></c:url>">
								<span class="glyphicon glyphicon-edit"></span>
						</a></td>
						<td>
							<!-- Tipo de destino: Post, URL o archivo adjunto --> <c:choose>
								<c:when test="${item.tipoDestino eq 'Post'}">
									<a
										href="<c:url value="/avisos/ver/individual?id=${item.postInternalId}"></c:url>"
										class="btn btn-primary"> <span
										class="glyphicon glyphicon-info-sign"></span>
									</a>
								</c:when>
								<c:when test="${item.tipoDestino eq 'URL'}">
									<a href="${item.urlDestino }" class="btn btn-primary"> <span
										class="glyphicon glyphicon-info-sign"></span>
									</a>
								</c:when>
								<c:when test="${item.tipoDestino eq 'Archivo'}">
									<a
										href="<c:url value="/resources/archivosAdjuntos/${item.postInternalId}"></c:url>"
										class="btn btn-primary"> <span
										class="glyphicon glyphicon-info-sign"></span>
									</a>
								</c:when>
								<c:otherwise>
									<a
										href="<c:url value="/avisos/ver/individual?id=${item.postInternalId}"></c:url>"
										class="btn btn-primary"> <span
										class="glyphicon glyphicon-info-sign"></span>
									</a>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<!-- Botón eliminar -->
							<button type="button" class="btn btn-danger" data-toggle="modal"
								data-target=".bs-delete-modal-sm${item.postInternalId}">
								<span class="glyphicon glyphicon-remove"></span>
							</button> <!-- Popup de confirmación de eliminación -->
							<div class="modal fade bs-delete-modal-sm${item.postInternalId}"
								tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
								aria-hidden="true">
								<div class="modal-dialog modal-sm">
									<div class="modal-content">
										<div class="modal-header bg-primary">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel">Eliminar aviso</h4>
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