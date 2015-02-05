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
			<legend><c:out value="${modo}"></c:out>	aviso</legend>

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

			<!-- Tipo de Aviso -->
			<div class="form-group">
				<label class="control-label col-lg-2" for="tipoAviso">Tipo</label>
				<div class="col-lg-10">
					<form:select path="tipoAviso">
     					<form:option value="-" label="Selecciona Uno"/>
						<form:options items="${aviso.tiposAviso}" />
					</form:select>
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

			<!-- Prioridad del aviso -->
			<div class="form-group">
				<label class="control-label col-lg-2" for="prioridadAviso">Prioridad</label>
				<div class="col-lg-10">
					<form:select path="prioridadAviso">
     					<form:option value="-" label="Selecciona Una"/>
						<form:options items="${aviso.prioridadesAviso}" />
					</form:select>
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

			<!-- Comienzo Publicación-->
			<div class="form-group">
				<label class="control-label col-md-2" for="comienzoPublicacion">Comienzo Publicación</label>
				<div class="col-md-2">
					<form:input id="comienzoPublicacion" path="comienzoPublicacion" />
				</div>
			</div>

			<!-- Fin Publicación -->
			<div class="form-group">
				<label class="control-label col-md-2" for="finPublicacion">Fin de Publicación</label>
				<div class="col-md-2">
					<form:input id="finPublicacion"	path="finPublicacion" />
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
						value="<c:out value="${modo}"></c:out>	aviso" />
				</div>
			</div>
		</fieldset>
	</form:form>
</section>
<script>
	$(function() {
		$("#comienzoPublicacion").datetimepicker({format:'Y/m/d H:i'});
		$('#finPublicacion').datetimepicker({format:'Y/m/d H:i'});
	});
</script>