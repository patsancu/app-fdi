<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="elemento" tagdir="/WEB-INF/tags/portal/elementos"%>
<c:forEach items="${avisos}" var="aviso">
	<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
		<div class="caption panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">
					<!-- Ver aviso -->
					<a href="<spring:url value="/aviso/{id}"><spring:param name="id" value="${aviso.id}" /></spring:url>">${aviso.titulo}</a>

					<!-- Editar aviso -->
					<a class="pull-right"
						href="<spring:url value="/avisos/{id}"><spring:param name="id" value="${aviso.id}" /></spring:url>">">
						<span hint="Editar aviso" class="glyphicon glyphicon-edit "></span>
					</a>


					<!-- Eliminar aviso -->
					<elemento:popUpAccion idModal="${aviso.postInternalId}"
						nombreAccionContraria="Cancelar" nombreAccion="borrar"
						nombreElementoAfectado="${aviso.titulo}"
						colocarExtremo="derecha"
						>
						<jsp:attribute name="texto">
								¿Realmente desea borrar el aviso ${aviso.titulo}?</jsp:attribute>
						<jsp:attribute name="urlSiAcepta">
									<c:url
								value="/avisos/gestor/eliminar?id=${aviso.postInternalId}"></c:url>
								</jsp:attribute>
					</elemento:popUpAccion>


				</div>
			</div><!-- panel-heading -->
			
			<h3></h3>
			<div class="panel-body">
				<p>${aviso.fechaPublicacion}</p>
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