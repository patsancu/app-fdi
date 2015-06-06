<%--

    This file is part of Portal Web de la FDI.

    Portal Web de la FDI is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Portal Web de la FDI is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with Portal Web de la FDI.  If not, see <http://www.gnu.org/licenses/>.

--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<title><c:out value="${modo}
"></c:out></title>



<section class="container center">
	<form:form modelAttribute="reserva" class="form-horizontal"
		method="${method}">
		<form:errors path="*" cssClass="alert alert-danger" element="div" />

		<c:if test="${! empty error}">
			<div class="alert alert-danger">
				¡Error!
				<c:out value="${error}" />
			</div>
		</c:if>


		<fieldset>
			<legend>
				<c:out value="${modo}"></c:out>
				<spring:message
						code="editor.reservas.reserva" />
			</legend>

			<div class="alert alert-warning">
				<spring:message code="editor.reservas.nota.fechas" />
			</div>


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
				<label class="control-label col-lg-2" for="aclaraciones"><spring:message
						code="editor.reservas.aclaraciones" /></label>
				<div class="col-lg-10">
					<form:textarea path="aclaraciones" type="text"
						class="form:input-large" />
				</div>
			</div>

			<!-- Comienzo Reserva-->
			<div class="form-group fecha">
				<label class="control-label col-md-2" for="fechaInicio"><spring:message
						code="editor.reservas.comienzo" /> </label>
				<div class="col-md-2">
					<form:input path="fechaInicio" />
				</div>
			</div>

			<!-- Fin Reserva -->
			<div class="form-group fecha">
				<label class="control-label col-md-2" for="fechaFin"><spring:message
						code="editor.reservas.fin" /></label>
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
	var logic = function(currentDateTime) {
		this.setOptions({
			minTime : '09:00',
			maxTime : '21:00',
			todayButton : true
		});
	};

	var logicWeekends = function(currentDateTime) {
		if (currentDateTime.getDay() == 6 || currentDateTime.getDay() == 0) {
			alert("Ha escogido día festivo.")
		}
	}

	$(function() {
		$("#fechaInicio").datetimepicker({
			format : 'Y/m/d H:i',
			step : 15,
			minDate : '0',
			onChangeDateTime : logic,
			onShow : logic,
			onSelectDate : logicWeekends
		});
		$('#fechaFin').datetimepicker({
			format : 'Y/m/d H:i',
			step : 15,
			minDate : '0',
			onChangeDateTime : logic,
			onShow : logic,
			onSelectDate : logicWeekends
		});
	});

	/* jQuery('#datetimepicker_rantime').datetimepicker({
		onChangeDateTime : logic,
		onShow : logic
	}); */
</script>