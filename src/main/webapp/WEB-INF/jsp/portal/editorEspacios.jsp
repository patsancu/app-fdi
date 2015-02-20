<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<title><c:out value="${modo}"></c:out> espacio</title>
<section class="container center">
	<form:form modelAttribute="espacio" class="form-horizontal"
		method="${method}">
		<form:errors path="*" cssClass="alert alert-danger" element="div" />
		<fieldset>
			<legend>
				<c:out value="${modo}"></c:out>
				espacio
			</legend>


			<!-- Nombre de espacio -->
			<div id="nombre" class="form-group">
				<label class="control-label col-lg-2" for="nombre">Nombre
					Espacio</label>
				<div class="col-lg-10">
					<form:input path="nombre" type="text"
						class="form:input-large" />
				</div>
			</div>

			<!-- Aforo -->
			<div id="aforo" class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="titulo">Aforo</label>
				<div class="col-lg-10">
					<form:input path="aforo" type="text" class="form:input-large" />
				</div>
			</div>

			<!-- Notas -->
			<div id="notas" class="form-group">
				<label class="control-label col-lg-2" for="notas">Notas</label>
				<div class="col-lg-10">
					<form:textarea path="notas" type="text" class="form:input-large" />
				</div>
			</div>
			


			<!-- Tipo de Aviso -->
			<div id="tipoAviso" class="form-group">
				<label class="control-label col-lg-2" for="tipoEspacioEnum">Tipo</label>
				<div class="col-lg-10">
					<form:select path="tipoEspacio">
						<form:option value="-" label="Selecciona Uno" />
						<form:options items="${tiposEspacios}" />
					</form:select>
				</div>
			</div>



			<!-- Botón crear aviso -->
			<div class="form-group add">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="<c:out value="${modo}"></c:out>	espacio" />
				</div>
			</div>
		</fieldset>
	</form:form>
</section>
<script>
	tinymce.init({
		selector : '.notas'
	});
</script>

<style>
#tabbedContent {
	margin-top: 20px;
}
</style>