<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">

<!-- Datepicker Fecha publicación inicio -->
<script>
	$(function() {
		$("#datepickerInicio").datepicker({
			"dateFormat" : "yy-mm-dd"
		});
	});
</script>

<!-- Timepicker hora publicación inicio -->
<script>
	$(function horaInicio() {
		$('#seleccionHoraInicio').timepicker({
			'timeFormat' : 'H:i',
			'scrollDefault' : 'now',
			'useSelect' : true
		});
	});
</script>

<!-- Datepicker Fecha publicación fin -->
<script>
	$(function() {
		$("#datepickerFin").datepicker({
			"dateFormat" : "yy-mm-dd"
		});
	});
</script>

<!-- Timepicker hora publicación fin -->
<script>
	$(function() {
		$('#seleccionHoraFin').timepicker({
			'timeFormat' : 'H:i',
			'scrollDefault' : 'now',
			'useSelect' : true
		});
	});
</script>


<!-- Datepicker fecha evento-->
<script>
	$(function() {
		$("#datepickerEvento").datepicker({
			"dateFormat" : "yy-mm-dd"
		});
	});
</script>

<script>
	$(function() {
		$('#seleccionHoraEvento').timepicker({
			'timeFormat' : 'H:i',
			'scrollDefault' : 'now',
			'useSelect' : true
		});
	});
</script>

<c:url var="jq"
	value="/js/jquery-timepicker-master/jquery.timepicker.min.js" />
<script type="text/javascript" src="${jq}"></script>
<c:url var="css1"
	value="/js/jquery-timepicker-master/jquery.timepicker.css" />
<link rel="stylesheet" href="${css1}">



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

<title><c:out value="${modo}"></c:out> aviso</title>




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
				<label class="control-label col-lg-2" for="etiqueta">Etiqueta</label>
				<div class="col-lg-10">
					<form:input id="etiqueta" path="etiqueta" type="text"
						class="form:input-large" />
				</div>
			</div>

			<!-- Hora evento-->
			<div class="form-group">
				<label class="control-label col-lg-2" for="hora">Hora de
					evento</label>
				<div class="col-lg-10">
					<%-- <form:input id="seleccionHoraEvento" path="horaEvento"
						 /> --%>
					<%-- class="form:input-large" --%>
					<form:input id="seleccionHoraEvento" style="margin-left: 30px;"
						path="horaEvento" />
				</div>
				<script>
					
				</script>
			</div>

			<!-- Fecha evento-->
			<div class="form-group">
				<label class="control-label col-lg-2" for="dia">Fecha de
					evento</label>
				<div class="col-lg-10">
					<form:input readonly="true" id="datepickerEvento" path="diaEvento" />
				</div>
			</div>

			<!-- Hora publicación inicio-->
			<div class="form-group">
				<label class="control-label col-md-2" for="hora">Hora de
					publicación (inicio)</label>
				<div class="col-md-2">
					<form:input id="seleccionHoraInicio" path="horaPublicacionInicio"
						class="form:input-large" />
				</div>
			</div>

			<!-- Fecha publicación inicio-->
			<div id="datetimepicker" class="form-group">
				<label class="control-label col-md-2" for="dia">Fecha de
					publicación (inicio)</label>
				<div class="col-md-2">
					<form:input readonly="true" id="datepickerInicio"
						path="diaPublicacionInicio" />
				</div>
			</div>


			<!-- Hora publicación fin-->
			<div class="form-group">
				<label class="control-label col-lg-2" for="hora">Hora de
					publicación (fin)</label>
				<div class="col-lg-10">
					<form:input id="seleccionHoraFin" path="horaPublicacionFin"
						class="form:input-large" />
				</div>
			</div>

			<!-- Fecha publicación fin-->
			<div id="datetimepicker" class="form-group">
				<label class="control-label col-lg-2" for="dia">Fecha de
					publicación (fin)</label>
				<div class="col-lg-10">
					<form:input readonly="true" id="datepickerFin"
						path="diaPublicacionFin" />
				</div>
			</div>

			<!-- Lugar -->
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="etiqueta">Lugar</label>
				<div class="col-lg-10">
					<form:select path="lugar" id="lugar">Fdi
						<form:option value="Fdi-Salón de actos">Fdi-Salón de actos</form:option>
						<form:option value="Fdi-Aula 12">Fdi-Aula 12</form:option>
						<form:option value="Fdi-Laboratorio 7">Fdi-Laboratorio 7</form:option>
						<form:option value="Fdi-Despacho 321">Fdi-Despacho 321</form:option>
					</form:select>
				</div>
			</div>

			<!-- Duración estimada -->
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2"
					for="duracionEstimada">duracionEstimada</label>
				<div class="col-lg-10">
					<form:select path="duracionEstimada" id="duracionEstimada">
						<form:option value="1h">1h</form:option>
						<form:option value="1h30">1h30</form:option>
						<form:option value="2h">2h</form:option>
						<form:option value="2h30">2h30</form:option>
						<form:option value="3h">3h</form:option>
						<form:option value="Todo el día">Todo el día</form:option>
					</form:select>
				</div>
			</div>

			<!-- Archivo adjunto -->
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
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="Guardar aviso" />
				</div>
			</div>
		</fieldset>
	</form:form>



</section>



