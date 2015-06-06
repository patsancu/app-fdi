<%--

    This file is part of Portal Web de la FDI.

    Portal Web de la FDI is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Portal Web de la FDI is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with Portal Web de la FDI.  If not, see <http://www.gnu.org/licenses/>.

--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script type="text/javascript">
	$('#myModal').modal({
		show : false,
		keyboard : false
	});
</script>

<section class="container">
	<h3>
		<a href="<spring:url value="/avisos/nuevo"></spring:url>">
			Crear nuevo aviso</a>
	</h3>
</section>

<section class="container">
	<!-- <div class="row"> -->
	<c:forEach items="${avisos}" var="aviso">
		<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
			<!-- <div class="row "> -->
			<%-- <img
							src="<c:url value="/resource/images/${aviso.avisoId}.png"></c:url>"
							alt="image" style="width: 100%" /> --%>
			<div class="caption panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						<!-- Ver aviso -->
						<a
							href="<spring:url value="/aviso/{id}"><spring:param name="id">${aviso.id}</spring:param></spring:url>">${aviso.titulo}</a>
						<!-- Editar aviso -->
						<a class="pull-right"
							href="<c:url value="/avisos/gestor/editar?id=${aviso.postInternalId}"></c:url>">
							<span hint="Editar aviso" class="glyphicon glyphicon-edit "></span>
						</a>


						<%-- <!-- Eliminar aviso -->
							<a class="pull-right"
								href="<c:url value="/avisos/gestor/eliminar?id=${aviso.postInternalId}"></c:url>">
								<span class="glyphicon glyphicon-remove-sign"></span>
							</a> --%>

						<!-- Botón eliminar -->
						<a data-toggle="modal" class="pull-right btn"
							data-target=".bs-delete-modal-sm${aviso.postInternalId}"> <span
							class="glyphicon glyphicon-remove"></span>
						</a>

						<!-- Popup de confirmación de eliminación -->
						<div class="modal fade bs-delete-modal-sm${aviso.postInternalId}"
							tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
							aria-hidden="true">
							<div class="modal-dialog modal-sm">
								<div class="modal-content">
									<div class="modal-header bg-primary">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">&times;</button>
										<h4 class="modal-title" id="myModalLabel">Eliminar aviso</h4>
									</div>
									<div class="modal-body">¿Está seguro de que desea eliminar el aviso "${aviso.titulo}"?</div>
									<div class="modal-footer ">
										<a class="btn btn-danger "
											href="<c:url value="/avisos/gestor/eliminar?id=${aviso.postInternalId}"></c:url>">
											Eliminar </a>
										<button type="button" class="btn btn-warning "
											data-dismiss="modal">Cancelar</button>
									</div>
								</div>
							</div>
						</div>
						<!-- Fin de Popup de confirmación de eliminación -->
					</div>
				</div>
				<h3></h3>
				<div class="panel-body">
					<p>${aviso.fechaPublicacionInicio}</p>
					<p>${aviso.tipoAviso}</p>
				</div>
				<div class="panel-footer">
					<p>
						<span class="label label-warning">${aviso.etiqueta}</span>
					</p>
				</div>
			</div>
			<!-- </div> -->
		</div>
	</c:forEach>
	<!-- </div> -->
</section>