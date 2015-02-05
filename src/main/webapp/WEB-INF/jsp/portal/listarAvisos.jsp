<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<section class="container">
	<table id="avisos" class="table table-hover">
		<thead>
			<tr>
				<th>Prioridad</th>
				<th>Tipo</th>
				<th>Título</th>
				<th>Contenido del aviso</th>
				<th>Etiqueta</th>
				<th>Publicado por</th>
				<th>Fecha creación</th>
				<th>Comienzo Publicación</th>
				<th>Fin Publicación</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${avisos}" var="item">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="caption">
						<tr>
							<td><c:if test="${item.prioridadAviso.description eq 'IMPORTANTE'}">
									<span class=" glyphicon glyphicon-exclamation-sign"></span>
								</c:if></td>
							<td>
								<!-- Tipo de destino: Post, URL o archivo adjunto --> <c:choose>
									<c:when test="${item.tipoAviso.description eq 'POST'}">
										<a
											href="<spring:url value="/aviso/{id}"><spring:param name="id" value="${item.id}" /></spring:url>" class="btn btn-primary"> <span
											class="glyphicon glyphicon-info-sign"></span>
										</a>
									</c:when>
									<c:when test="${item.tipoAviso.description eq 'URL'}">
										<a href="${item.urlDestino}" class="btn btn-primary" target="_blank"> <span
											class="glyphicon glyphicon-info-sign"></span>
										</a>
									</c:when>
									<c:when test="${item.tipoAviso.description eq 'ARCHIVO'}">
										<a
											href="<spring:url value="/box/{id}"><spring:param name="id" value="${item.id}" /></spring:url>"
											class="btn btn-primary"> <span
											class="glyphicon glyphicon-info-sign"></span>
										</a>
									</c:when>
									<c:otherwise>
										<a
											href="<spring:url value="/aviso/{id}"><spring:param name="id" value="${item.id}" /></spring:url>"
											class="btn btn-primary"> <span
											class="glyphicon glyphicon-info-sign"></span>
										</a>
									</c:otherwise>
								</c:choose>
							</td>
							<td>${item.titulo}</td>
							<td>${fn:substring(item.contenidoAviso, 0, 25)}...</td>
							<td>${item.etiqueta}</td>
							<td>${item.autor }</td>
							<td><joda:format value="${item.fechaCreacion}" pattern="yyyy/MM/dd HH:mm" /></td>
							<td><joda:format value="${item.comienzoPublicacion}" pattern="yyyy/MM/dd HH:mm" /></td>
							<td><joda:format value="${item.finPublicacion}" pattern="yyyy/MM/dd HH:mm" /></td>
							<td><a class="btn btn-success"
								href="<spring:url value="/avisos/{id}"><spring:param name="id" value="${item.id}" /></spring:url>">
									<span class="glyphicon glyphicon-edit"></span>
							</a>
							<form:form action="${deleteAction}/${item.id}" method="DELETE">
								<!-- Botón eliminar -->
								<button type="button" class="btn btn-danger" data-toggle="modal"
									data-target=".bs-delete-modal-sm${item.id}">
									<span class="glyphicon glyphicon-remove"></span>
								</button> <!-- Popup de confirmación de eliminación -->
								<div class="modal fade bs-delete-modal-sm${item.id}"
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
											<div class="modal-body">¿Está seguro de que desea eliminar el aviso "${item.titulo}"?</div>
											<div class="modal-footer ">
												<a class="btn btn-danger "
													href="<c:url value="/gestor/eliminar?id=${item.postInternalId}"></c:url>">
													Eliminar </a>
												<button type="button" class="btn btn-warning "
													data-dismiss="modal">Cancelar</button>
											</div>
										</div>
									</div>
								</div> <!-- Fin de  Popup de confirmación de eliminación -->
							</form:form>
							</td>
						</tr>
					</div>
				</div>
			</c:forEach>
		</tbody>
	</table>
</section>

<script type="text/javascript">
	$(document).ready(function() { /* Se deshabilita el orden por estos campos */
		$('#myModal').modal({
			show : false,
			keyboard : false
		});
		$('#avisos').DataTable({
			"aoColumnDefs" : [ {
				'bSortable' : false,
				'aTargets' : [ 7 ]
			}, //info
			{
				'bSortable' : false,
				'aTargets' : [ 8 ]
			}, //editar
			{
				'bSortable' : false,
				'aTargets' : [ 9 ]
			} //eliminar
			],

			//Cambio de texto de menus
			"language" : {
				"lengthMenu" : "Mostrar _MENU_ resultados por pagina",
				"zeroRecords" : "No se ha encontrado ningun resultado",
				"info" : "Página _PAGE_ de _PAGES_",
				"infoEmpty" : "No hay información",
				"infoFiltered" : "(filtado de _MAX_ resultados totales)",
				"search" : "Buscar:",
				"paginate" : {
					"first" : "Primera",
					"last" : "Ultima",
					"next" : "Siguiente",
					"previous" : "Anterior"
				},
			}
		});
	});
</script>