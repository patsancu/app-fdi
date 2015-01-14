<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="elemento" tagdir="/WEB-INF/tags/elementos"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/anuncios"%>

<t:genericPage titulo="">
	<jsp:body>
		<table class="container">
			<elemento:listarAvisos__listadoAvisos></elemento:listarAvisos__listadoAvisos>
		</table>	
	</jsp:body>
	
</t:genericPage>

<%-- <html>
<head></head>
<body>
	<c:forEach items="${avisos}" var="item">
		<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
			<div class="caption">
				<p>${item.titulo}</p>
				<p><a
					href="<c:url value="/avisos/ver/individual?id=${item.postInternalId}"></c:url>"
					> ${item.contenidoAviso}
				</a></p>
				<p>${item.tipoAviso}</p>
				<p>${item.etiqueta}</p>
				<p>
					<a class="btn btn-success"
						href="<c:url value="/avisos/gestor/editar?id=${item.postInternalId}"></c:url>">
						<span class="glyphicon glyphicon-edit"></span>
					</a>
				</p>
				<p></p>
				<p><a
					href="<c:url value="/avisos/gestor/eliminar?id=${item.postInternalId}"></c:url>"
					class="btn btn-danger"><span
						class="glyphicon glyphicon-remove-sign"></span></a></p>
						<hr>
				</p>
			</div>
		</div>
	</c:forEach>
</body>
</html>

 --%>