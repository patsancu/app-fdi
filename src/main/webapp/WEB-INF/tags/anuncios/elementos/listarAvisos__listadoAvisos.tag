<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="elemento" tagdir="/WEB-INF/tags/anuncios/elementos"%>



<c:forEach items="${avisos}" var="item">
	<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
		<div class="caption">
			<tr>
				<td><c:if test="${item.tipoAviso eq 'Importante'}">
						<span class=" glyphicon glyphicon-exclamation-sign"></span>
					</c:if></td>
				<td>${item.titulo}</td>
				<td>${fn:substring(item.contenidoAviso, 0, 25)}...</td>
				<td>${item.tipoAviso}</td>
				<td>${item.etiqueta}</td>
				<td>Creado el ${fn:substring(item.fechaCreacion,0,19	)}</td>
				<td>Publicacion: ${fn:substring(item.fechaPublicacion,0,19	)}</td>
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
					<!-- Eliminar aviso -->
					<elemento:popUpAccion idModal="${item.postInternalId}"
						nombreAccionContraria="Cancelar" nombreAccion="borrar"
						nombreElementoAfectado="${item.titulo}"
						colocarExtremo="derecha"
						>
						<jsp:attribute name="texto">
								¿Realmente desea borrar el aviso ${item.titulo}?</jsp:attribute>
						<jsp:attribute name="urlSiAcepta">
									<c:url
								value="/avisos/gestor/eliminar?id=${item.postInternalId}"></c:url>
								</jsp:attribute>
					</elemento:popUpAccion>
					
				</td>
			</tr>
		</div>
	</div>
</c:forEach>
