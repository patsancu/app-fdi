	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<c:url var="jq"
	value="/js/bootstrap-datetimepicker-0.0.11/js/bootstrap-datetimepicker.min.js" />
<script type="text/javascript" src="${jq}"></script>
<c:set var="atributo" value="aviso" />
<c:choose>
	<c:when test="${not empty aviso.titulo}">
		<c:set var="modo" value="Editar" />
		<%-- <c:set var="atributo" value="aviso"/> --%>
	</c:when>
	<c:otherwise>
		<c:set var="modo" value="Crear" />
		<%-- <c:set var="atributo" value="nuevoAviso"/> --%>
	</c:otherwise>
</c:choose>



<section class="container center">
	<%-- <form:form modelAttribute="nuevoAviso" class="form-horizontal"> --%>
	<form:form modelAttribute="${atributo}" class="form-horizontal"
		enctype="multipart/form-data">
		<!-- enctype="multipart/form-data" SOLO cuando haya subida de archivos -->
		<%-- nuevoAviso is called form-backing bean --%>
		<%-- <form:errors path="*" cssClass="alert alert-danger" element="div" /> --%>
		<fieldset>
			<legend>
				<c:out value="${modo}"></c:out>
				aviso
			</legend>

			<!-- MUY IMPORTANTE PARA LA EDICIÓN
					Si no se pone, crea un dato nuevo en la db -->
			<form:input type="hidden" id="postInternalId" path="postInternalId" />

			<!-- Titulo -->
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="titulo"><spring:message
						code="addAviso.form.titulo.label" /></label>
				<div class="col-lg-10">
					<form:input id="titulo" path="titulo" type="text"
						class="form:input-large" />
					<form:errors path="titulo" cssClass="text-danger" />
				</div>
			</div>

			<!-- Contenido -->
			<div class="form-group">
				<label class="control-label col-lg-2" for="contenidoAviso">Contenido
					de aviso</label>
				<div class="col-lg-10">
					<form:textarea id="contenidoAviso" path="contenidoAviso"
						type="text" class="form:input-large" />
				</div>
			</div>

			<!-- Tipo de destino: Post, URL o archivo adjunto -->
			<div class="form-group">
				<label class="control-label col-lg-2" for="tipoDestino">Tipo
					de destino</label>
				<div class="col-lg-10">
					<form:radiobutton path="tipoDestino" value="URL" />
					URL
					<form:radiobutton path="tipoDestino" value="Post" />
					Post
					<form:radiobutton path="tipoDestino" value="Archivo" />
					Archivo
				</div>
			</div>

			<!-- urlDestino -->
			<!-- Tipo de aviso -->
			<div class="form-group">
				<label class="control-label col-lg-2" for="urlDestino">URL
					destino</label>
				<div class="col-lg-10">
					<form:input id="urlDestino" path="urlDestino" type="text"
						class="form:input-large" />
				</div>
			</div>


			<!-- Tipo de aviso -->
			<div class="form-group">
				<label class="control-label col-lg-2" for="tipoAviso">Tipo
					de aviso</label>
				<div class="col-lg-10">
					<form:radiobutton path="tipoAviso" value="Importante" />
					Importante
					<form:radiobutton path="tipoAviso" value="Normal" />
					Normal
				</div>
			</div>

			<!-- Etiqueta -->
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="etiqueta">Etiqueta</label>
				<div class="col-lg-10">
					<form:input id="etiqueta" path="etiqueta" type="text"
						class="form:input-large" />
					<form:errors path="etiqueta" cssClass="text-danger" />
				</div>
			</div>

			<!-- Hora publicación -->
			<div class="form-group">
				<label class="control-label col-lg-2" for="hora">Hora</label>
				<div class="col-lg-10">
					<form:select id="hora" path="hora">
						<c:forEach items="${horas}" var="hora" varStatus="theCount">
							<option value="${hora}">${hora}</option>
						</c:forEach>
					</form:select>

					<form:select id="minuto" path="minuto">
						<c:forEach items="${minutos}" var="minuto" varStatus="theCount">
							<option value="${minuto}">${minuto}</option>
						</c:forEach>
					</form:select>
				</div>
			</div>



			<!-- Fecha publicación -->
			<div id="datetimepicker" class="form-group">
				<label class="control-label col-lg-2s" for="fechaPublicacion">Fecha</label>
				<div class="col-lg-10">
					<form:select id="dia" path="dia">
						<c:forEach items="${dias}" var="dia" varStatus="theCount">
							<option value="${dia}">${dia}</option>
						</c:forEach>
					</form:select>

					<form:select id="mes" path="mes">
						<c:forEach items="${meses}" var="mes" varStatus="theCount">
							<option value="${theCount.count}">${mes}</option>
						</c:forEach>
					</form:select>

					<form:select id="anyo" path="anyo">
						<c:forEach items="${anyos}" var="anyo" varStatus="theCount">
							<option value="${anyo}">${anyo}</option>
						</c:forEach>
					</form:select>
				</div>

			</div>


			<div class="form-group">
				<label class="control-label col-lg-2" for="adjunto"> Añadir
					archivo adjunto </label>
				<div class="col-lg-10">
					<form:input id="adjunto" path="adjunto" type="file"
						class="form:input-large" />
				</div>
			</div>

			<!-- Botón crear aviso -->
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<p>
					<p>
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Crear aviso" />
				</div>
			</div>




		</fieldset>
	</form:form>
</section>



<!-- jQuery y librería JS para fecha -->
<script type="text/javascript"
	src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
	
</script>
<script type="text/javascript"
	src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
	
</script>
<script type="text/javascript">
	$('#datetimepicker').datetimepicker({
		//format: 'dd/MM/yyyy hh:mm:ss',
		format : 'dd/MM/yyyy hh:mm',
		//language: 'pt-BR'
		language : 'en-US'
	});
</script>