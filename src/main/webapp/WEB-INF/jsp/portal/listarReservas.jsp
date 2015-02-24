<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>
<section class="container">
	<c:out value="${logueado}"></c:out>
	<table id="reservas" class="table table-hover">
		<thead>
			<tr>
				<th>Titular</th>
				<th>Desde</th>
				<th>Hasta</th>
				<th>Espacio</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${reservas}" var="item">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="caption">
						<tr>
							<td>${item.titular}</td>
							<td>${item.fechaInicio}</td>
							<td>${item.fechaFin}</td>
							<td><a href="<spring:url value="/espacios/{id}"><spring:param name="id" value="${item.espacio.id}" /></spring:url>">${item.espacio.nombre}</a> </td>
							<td><a class="btn btn-success"
								href="<spring:url value="/reservas/{id}"><spring:param name="id" value="${item.id}" /></spring:url>">
									<span class="glyphicon glyphicon-edit"></span>
							</a> <form:form action="${deleteAction}/${item.id}" method="DELETE">
									<!-- Botón eliminar -->
									<button type="button" class="btn btn-danger"
										data-toggle="modal"
										data-target=".bs-delete-modal-sm${item.id}">
										<span class="glyphicon glyphicon-remove"></span>
									</button>
									<!-- Popup de confirmación de eliminación -->
									<div class="modal fade bs-delete-modal-sm${item.id}"
										tabindex="-1" role="dialog"
										aria-labelledby="mySmallModalLabel" aria-hidden="true">
										<div class="modal-dialog modal-sm">
											<div class="modal-content">
												<div class="modal-header bg-primary">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">&times;</button>
													<h4 class="modal-title" id="myModalLabel">Eliminar
														reserva</h4>
												</div>
												<div class="modal-body">¿Está seguro de que desea
													eliminar la reserva en "${item.espacio.nombre}"?</div>
												<div class="modal-footer ">
													<button type="submit" class="btn btn-danger">Eliminar
													</button>
													<button type="button" class="btn btn-warning "
														data-dismiss="modal">Cancelar</button>
												</div>
											</div>
										</div>
									</div>
									<!-- Fin de  Popup de confirmación de eliminación -->
								</form:form></td>
						</tr>
					</div>
				</div>
			</c:forEach>
		</tbody>
	</table>
</section>