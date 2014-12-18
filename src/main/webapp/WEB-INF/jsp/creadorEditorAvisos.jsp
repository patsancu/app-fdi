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

<!-- Datepicker -->
<script>
$(function() {
	$( "#datepickerInicio" ).datepicker({"dateFormat": "yy-mm-dd"});
});
</script>

<!-- Timepicker -->
<script>
  $(function() {
    $('#seleccionHoraInicio').timepicker({ 'timeFormat': 'H:i:s','scrollDefault': 'now'  });
  });
  </script>
<script>
  $('#botonAhora').on('click', function (){
      $('#seleccionHoraInicio').timepicker('setTime', new Date());
  });
</script>
<!-- Datepicker -->
<script>
$(function() {
	$( "#datepickerFin" ).datepicker({"dateFormat": "yy-mm-dd"});
});
</script>

<!-- Timepicker -->
<script>
  $(function() {
    $('#seleccionHoraFin').timepicker({ 'timeFormat': 'H:i:s','scrollDefault': 'now'  });
  });
  </script>
<script>
  $('#botonAhora').on('click', function (){
      $('#seleccionHoraFin').timepicker('setTime', new Date());
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
				<label class="control-label col-lg-2 col-lg-2" for="etiqueta">Etiqueta</label>
				<div class="col-lg-10">
					<form:input id="etiqueta" path="etiqueta" type="text"
						class="form:input-large" />
				</div>
			</div>

			<!-- Hora publicación inicio-->
			<div class="form-group">
				<label class="control-label col-lg-2" for="hora">Hora de publicación (inicio)</label>
				<div class="col-lg-10">
					<form:input id="seleccionHoraInicio" path="horaPublicacionInicio" class="form:input-large" />
				</div>
			</div>

			<!-- Fecha publicación inicio-->
			<div id="datetimepicker" class="form-group">
				<label class="control-label col-lg-2" for="dia">Fecha de publicación (inicio)</label>
				<div class="col-lg-10">
					<form:input id="datepickerInicio" path="diaPublicacionInicio" />
				</div>
			</div>
			
			
			<!-- Hora publicación fin-->
			<div class="form-group">
				<label class="control-label col-lg-2" for="hora">Hora de publicación (fin)</label>
				<div class="col-lg-10">
					<form:input id="seleccionHoraFin" path="horaPublicacionFin" class="form:input-large" />
				</div>
			</div>

			<!-- Fecha publicación fin-->
			<div id="datetimepicker" class="form-group">
				<label class="control-label col-lg-2" for="dia">Fecha de publicación (fin)</label>
				<div class="col-lg-10">
					<form:input id="datepickerFin" path="diaPublicacionFin" />
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



