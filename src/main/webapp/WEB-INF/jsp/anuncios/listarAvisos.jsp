<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://cdn.datatables.net/1.10.4/js/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
<script type="text/javascript" charset="utf8"
	src="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js"></script>


<script type="text/javascript">
	$('#myModal').modal({
		show : false,
		keyboard : false
	});
</script>

<script type="text/javascript">	
	$(document).ready(function() { /* Se deshabilita la ordenación por estos campos */
		$('#table_id').DataTable({
			"aoColumnDefs" : [ {
				'bSortable' : false,
				'aTargets' : [ 9 ]
			}, //info
			{
				'bSortable' : false,
				'aTargets' : [ 10 ]
			}, //editar
			{
				'bSortable' : false,
				'aTargets' : [ 11 ]
			}//eliminar
			],
			
			//Cambio de texto de menus
			"language": {
	            "lengthMenu": "Mostrar _MENU_ resultados por pagina",
	            "zeroRecords": "No se ha encontrado ningun resultado",
	            "info": "Página _PAGE_ de _PAGES_",
	            "infoEmpty": "No hay información",
	            "infoFiltered": "(filtado de _MAX_ resultados totales)",
	            "search":         "Buscar:",
		        "paginate": {
		            "first":      "Primera",
		            "last":       "Ultima",
		            "next":       "Siguiente",
		            "previous":   "Anterior"
		        },
	        }
		});
	});
</script>


<section class="container">
	<table id="table_id" class="table table-hover">
		<thead>
			<tr>
				<th>Importancia</th>
				<th>Título</th>
				<th>Contenido del aviso</th>
				<th>Duración estimada</th>
				<th>Lugar</th>
				<th>Fecha evento</th>
				<th>Aforo</th>
				<th>Etiqueta</th>
				<th>Publicado por</th>
				<!-- th>Fecha creación</th>
				<th>Fecha publicación inicio</th>
				<th>Fecha publicación fin</th> -->
				<th>Info</th>
				<th>Editar</th>
				<th>Eliminar</th>

			</tr>
		</thead>

		<tbody>
			<c:forEach items="${avisos}" var="item">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="caption">
						<tr>
							<td><c:if test="${item.tipoAviso eq 'Importante'}">
									<span class=" glyphicon glyphicon-exclamation-sign"></span>
								</c:if></td>
							<td>${item.titulo}</td>
							<td>${fn:substring(item.contenidoAviso, 0, 25)}...</td>
							<td>${item.duracionEstimada}</td>
							<td>${item.lugar}</td>
							<td>${item.fechaEvento}</td>
							<td>${item.numeroPlazas}</td>
							<td>${item.etiqueta}</td>
							<td>${item.autor }</td>
							<%-- <td>${fn:substring(item.fechaCreacion,0,19	)}
							<td>${fn:substring(item.fechaPublicacionInicio,0,19	)}
							<td>${fn:substring(item.fechaPublicacionFin,0,19)} --%>
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
												<h4 class="modal-title" id="myModalLabel">Eliminar
													aviso</h4>
											</div>
											<div class="modal-body">¿Está seguro de que desea
												eliminar el aviso "${item.titulo}"?</div>
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
							</td>
						</tr>
					</div>
				</div>
			</c:forEach>
		</tbody>

	</table>

	<a href="<spring:url value="/" />" class="btn btn-default"> <span
		class="glyphicon-hand-left glyphicon"></span> Volver
	</a>
</section>