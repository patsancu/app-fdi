<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ attribute name="idModal" required="true"%>
<%@ attribute name="nombreAccion" required="true"%>
<%@ attribute name="urlSiAcepta" required="true"%>
<%@ attribute name="colocarExtremo" required="false"%>
<!-- derecha, izquierda -->
<%@ attribute name="titulo" required="false"%>
<!-- nombre de accion si ausente -->
<%@ attribute name="footer" required="false"%>
<%@ attribute name="texto" required="false"%>
<%@ attribute name="nombreAccionContraria" required="true"%>
<%@ attribute name="nombreElementoAfectado" required="true"%>

<!-- USAR SET PARA CADA POSIBLE ATRIBUTO -->

<c:choose>
	<c:when test="${colocarExtremo eq 'derecha' }">
		<c:set var="colocacion" value="pull-right" />
	</c:when>
	<c:when test="${colocarExtremo eq 'izquierda' }">
		<c:set var="colocacion" value="pull-left" />
	</c:when>
</c:choose>

<c:choose>
	<c:when test="${nombreAccion eq 'borrar' }">
		<c:set var="icono" value="glyphicon glyphicon-remove" />
		<c:set var="nombreModal" value="bs-delete-modal-sm" />
		<c:set var="botonAceptarAccion" value="btn btn-danger"/>
	</c:when>
	<c:when test="${nombreAccion eq 'crear' }">
		<c:set var="icono" value="glyphicon glyphicon-info-sign" />
		<c:set var="nombreModal" value="bs-create-modal-sm" />
		<c:set var="botonAceptarAccion" value="btn btn-info"/>
	</c:when>
</c:choose>



<a type="button"  class="btn ${colocacion }" data-toggle="modal" data-target=".${nombreModal}${idModal}"> 
	<span class="${icono }"></span>
</a>

<div class="modal fade ${nombreModal}${idModal}" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">${nombreAccion}</h4>
			</div>
			<div class="modal-body">
				${texto}
			</div>
			<div class="modal-footer ">
				<a class="${botonAceptarAccion}" href="${urlSiAcepta }">
					${nombreAccion } 
				</a>
				<button type="button" class="btn btn-warning " data-dismiss="modal">${nombreAccionContraria}</button>
			</div>
		</div>
		
	</div>
</div>

