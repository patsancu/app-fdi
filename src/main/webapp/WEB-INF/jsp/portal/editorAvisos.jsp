<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<title><c:out value="${modo}"></c:out> aviso</title>
<section class="container center">
	<form:form modelAttribute="aviso" class="form-horizontal"
		enctype="multipart/form-data" method="${method}">
		<form:errors path="*" cssClass="alert alert-danger" element="div" />
		<fieldset>
			<legend>
				<c:out value="${modo}"></c:out>
				aviso
			</legend>

			<!-- Menú pestañas -->
			<ul class="nav nav-tabs">
				<li class="active"><a href="#basic-details" data-toggle="tab">Datos
						básicos</a></li>
				<li><a href="#fechas" data-toggle="tab">Fechas</a></li>
			</ul>
			<!-- FIN Menú pestañas -->

			<!-- contenido en pestañas -->
			<div id="tabbedContent" class="tab-content">
				<!-- Datos básicos -->
				<div id="basic-details" class="tab-pane fade active in">

					<!-- Tipo de Aviso -->
					<div id="tipoAviso" class="form-group">
						<label class="control-label col-lg-2" for="tipoAviso">Tipo</label>
						<div class="col-lg-10">
							<form:select path="tipoAviso">
								<form:option value="-" label="Selecciona Uno" />
								<form:options items="${aviso.tiposAviso}" />
							</form:select>
						</div>
					</div>

					<!-- Titulo -->
					<div id="titulo" class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="titulo"><spring:message
								code="addAviso.form.titulo.label" /></label>
						<div class="col-lg-10">
							<form:input path="titulo" type="text" class="form:input-large" />
							<form:errors path="titulo" cssClass="text-danger" />
						</div>
					</div>

					<!-- Contenido -->
					<div id="contenidoAviso" class="form-group">
						<label class="control-label col-lg-2" for="contenidoAviso"
							onclick="k">Contenido de aviso</label>
						<div class="col-lg-10">
							<form:textarea path="contenidoAviso" type="text"
								class="form:input-large" />
						</div>
					</div>



					<!-- urlDestino -->
					<div id="urlDestino" class="form-group">
						<label class="control-label col-lg-2" for="urlDestino">URL
							destino</label>
						<div class="col-lg-10">
							<form:input id="urlDestino" path="urlDestino" type="text"
								class="form:input-large" />
						</div>
					</div>

					<!-- Prioridad del aviso -->
					<div id="prioridadAviso" class="form-group">
						<label class="control-label col-lg-2" for="prioridadAviso">Prioridad</label>
						<div class="col-lg-10">
							<form:select path="prioridadAviso">
								<form:option value="-" label="Selecciona Una" />
								<form:options items="${aviso.prioridadesAviso}" />
							</form:select>
						</div>
					</div>

					<!-- Etiqueta -->
					<div id="etiqueta" class="form-group">
						<label class="control-label col-lg-2" for="etiqueta">Etiqueta</label>
						<div class="col-lg-10">
							<form:input path="etiqueta" type="text" class="form:input-large" />
						</div>
					</div>
					<!-- Archivo adjunto -->
					<div id="adjunto" class="form-group">
						<label class="control-label col-lg-2" for="adjunto">
							Añadir archivo adjunto </label>
						<div class="col-lg-10">
							<form:input id="adjunto" path="adjunto" type="file"
								class="form:input-large" />
						</div>
					</div>

				</div>
				<!-- Detalles básicos -->

				<div id="fechas" class="tab-pane fade">

					<!-- Comienzo Publicación-->
					<div id="comienzoPublicacion" class="form-group">
						<label class="control-label col-md-2" for="comienzoPublicacion">Comienzo
							Publicación</label>
						<div class="col-md-2">
							<form:input path="comienzoPublicacion" />
						</div>
					</div>

					<!-- Fin Publicación -->
					<div id="finPublicacion" class="form-group">
						<label class="control-label col-md-2" for="finPublicacion">Fin
							de Publicación</label>
						<div class="col-md-2">
							<form:input path="finPublicacion" />
						</div>
					</div>

				</div>
				<!-- FIN Pestaña fechas -->


			</div>
			<!-- contenido en pestañas -->

			<!-- Botón crear aviso -->
			<div class="form-group add">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="<c:out value="${modo}"></c:out>	aviso" />
				</div>
			</div>
		</fieldset>
	</form:form>
</section>
<script>
	$(function() {
		$("#comienzoPublicacion").datetimepicker({
			format : 'Y/m/d H:i'
		});
		$('#finPublicacion').datetimepicker({
			format : 'Y/m/d H:i'
		});
	});
</script>
<script type="text/javascript">
	//p = $(function() {

	$("select").change(function() {
		var str = "";
		//$("select option:selected").each(function() {
		$("#tipoAviso option:selected").each(function() {

			str += $(this).text() + " ";
			$(".form-group").hide();
			$("#tipoAviso").show();
			$("#titulo").show();
			$("#prioridadAviso").show();
			$("#etiqueta").show();
			$("#comienzoPublicacion").show();
			$("#finPublicacion").show();

			var tipoAvisoSeleccionado = $(this).text();

			switch (tipoAvisoSeleccionado) {
			case "URL":
				$("#urlDestino").show();
				break;
			case "HTML":
				$("#contenidoAviso").show();
				break;
			case "ADJUNTO":
				$("#adjunto").show();
				break;
			}

		});

		//$( "div" ).text( str );
		//alert(str);
	}).change();
	//});
	/* $(document).ready(function(){
	 $('div').hide();
	 }); */
</script>
<script>
	tinymce.init({
		selector : 'textarea'
	});
</script>

<style>	
	#tabbedContent {
	margin-top: 20px;
}
</style>