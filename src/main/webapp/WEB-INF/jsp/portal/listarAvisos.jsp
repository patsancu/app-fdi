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
				<th><spring:message code="listado.prioridad"></spring:message></th>
				<th><spring:message code="listado.tipo"></spring:message></th>
				<th><spring:message code="listado.titulo"></spring:message></th>
				<th><spring:message code="listado.contenido.aviso"></spring:message></th>
				<th><spring:message code="listado.etiqueta"></spring:message></th>
				<th><spring:message code="listado.autor"></spring:message></th>
				<th><spring:message code="listado.fecha.creacion"></spring:message></th>
				<th><spring:message code="listado.fecha.publicacion.comienzo"></spring:message></th>
				<th><spring:message code="listado.fecha.publicacion.fin"></spring:message></th>
				<th><spring:message code="listado.acciones"></spring:message></th>
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
								<c:when test="${item.tipoAviso.name() eq 'POST'}">
									<a
										href="<spring:url value="/avisos/{id}/ver"><spring:param name="id" value="${item.id}" /></spring:url>" class="btn btn-primary"> <span
										class="glyphicon glyphicon-info-sign"></span>
									</a>
								</c:when>
								<c:when test="${item.tipoAviso.name() eq 'URL'}">
									<a href="${item.urlDestino}" class="btn btn-primary" target="_blank"> <span
										class="glyphicon glyphicon-info-sign"></span>
									</a>
								</c:when>
								<c:when test="${item.tipoAviso.name() eq 'ADJUNTO'}">
									<a
										href="${item.adjunto}"
										class="btn btn-primary"> <span
										class="glyphicon glyphicon-info-sign"></span>
									</a>
								</c:when>
								<c:otherwise>
									<a
										href="<spring:url value="/avisos/{id}/ver"><spring:param name="id" value="${item.id}" /></spring:url>"
										class="btn btn-primary"> <span
										class="glyphicon glyphicon-info-sign"></span>
									</a>
								</c:otherwise>
							</c:choose>
						</td>
						<td>${item.titulo}</td>
						<td>
						${fn:substring(item.contenidoAviso, 0, 23)}
						<c:if test="${fn:length(item.contenidoAviso) gt 23 }">
							...
						</c:if>
						
						
						</td>
						
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
											<h4 class="modal-title" id="myModalLabel"><spring:message code="listado.acciones.eliminar.anuncio"></spring:message></h4>
										</div>										
										<div class="modal-body"><spring:message code="listado.acciones.eliminar.warning"></spring:message></div>
										<div class="modal-footer ">
											<button type="submit" class="btn btn-danger"><spring:message code="listado.acciones.eliminar"></spring:message></button>											
											<button type="button" class="btn btn-warning " data-dismiss="modal"><spring:message code="listado.acciones.cancelar"></spring:message></button>
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
				"lengthMenu" : <spring:message code="listado.datatables.lengthmenu"></spring:message>,
				"zeroRecords" : <spring:message code="listado.datatables.zerorecords"></spring:message>,
				"info" : <spring:message code="listado.datatables.info"></spring:message>,
				"infoEmpty" : <spring:message code="listado.datatables.infoempty"></spring:message>,
				"infoFiltered" : <spring:message code="listado.datatables.infofiltered"></spring:message>,
				"search" : <spring:message code="listado.datatables.search"></spring:message>,
				"paginate" : { 
					"first" : <spring:message code="listado.datatables.first"></spring:message>,
					"last" : <spring:message code="listado.datatables.last"></spring:message>,
					"next" : <spring:message code="listado.datatables.next"></spring:message>,
					"previous" : <spring:message code="listado.datatables.previous"></spring:message>
				},
			}
		});
	});
</script>