<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<title><c:out value="${modo}"></c:out></title>
<section class="container center">
	<form:form modelAttribute="reserva" class="form-horizontal"
		method="${method}">
		<form:errors path="*" cssClass="alert alert-danger" element="div" />
		<fieldset>
			<legend>
				<c:out value="${modo}"></c:out>
				reserva
			</legend>


			<!-- Espacio -->
			<div id="id_espacio" class="form-group">
				<label class="control-label col-lg-2" for="id_espacio">Espacio</label>
				<div class="col-lg-10">
					<form:select path="id_espacio">
						<c:forEach items="${espacios}" var="item">
							<form:option value="${item.id}" label="${item.nombre}"></form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>

			<!-- aclaraciones -->
			<div id="aclaraciones" class="form-group">
				<label class="control-label col-lg-2" for="aclaraciones">Contenido
					de aviso</label>
				<div class="col-lg-10">
					<form:textarea path="aclaraciones" type="text"
						class="form:input-large" />
				</div>
			</div>

			<!-- Comienzo Reserva-->
			<div class="form-group fecha">
				<label class="control-label col-md-2" for="fechaInicio">Comienzo
					Reserva</label>
				<div class="col-md-2">
					<form:input path="fechaInicio" />
				</div>
			</div>

			<!-- Fin Reserva -->
			<div class="form-group fecha">
				<label class="control-label col-md-2" for="fechaFin">Fin de
					Reserva</label>
				<div class="col-md-2">
					<form:input path="fechaFin" />
				</div>
			</div>

			<!-- Botón crear aviso -->
			<div class="form-group add">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="<c:out value="${modo}"></c:out>	" />
				</div>
			</div>
		</fieldset>
	</form:form>
</section>




<!-- Date & Time picker -->
<script>
	$(function() {
		$("#fechaInicio").datetimepicker({
			format : 'Y/m/d H:i',
			step:15,
			minDate:'0'
		});
		$('#fechaFin').datetimepicker({
			format : 'Y/m/d H:i',
			step:15,
			minDate:'0'
		});
	});
</script>