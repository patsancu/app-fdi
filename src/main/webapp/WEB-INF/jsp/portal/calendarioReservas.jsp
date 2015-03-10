<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>

<section class="container center">
	<legend>Editor de reservas</legend>
	<div class="panel-body">
		Selección de espacio
		<select class="lg-4" id="selectorEspaciosGlobal">
			<option value="todos" label="TODOS" />
			<c:forEach items="${espaciosUsados}" var="espacio">
				<option value="${espacio.id}">${espacio.nombre}</option>
			</c:forEach>
		</select>
	</div>
</section>




<c:url value="/reservas/nuevo" var="postURLcrear" />
<c:url value="/reservas/" var="postURLactualizar" />



<div id='calendar'></div>




<div class="modal fade" id="modalCrearReserva" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">
					<c:out value="${modo}"></c:out>
					<spring:message code="editor.reservas.reserva" />
				</h4>
			</div>
			<form:form action="${postURLcrear}" modelAttribute="reserva"
				class="form-horizontal" method="${methodCrear}">
				<form:errors path="*" cssClass="alert alert-danger" element="div" />

				<c:if test="${! empty error}">
					<div class="alert alert-danger">
						¡Error!
						<c:out value="${error}" />
					</div>
				</c:if>


				<fieldset>

					<div class="modal-body">
						<div class="alert alert-warning">
							<spring:message code="editor.reservas.nota.fechas" />
						</div>


						<!-- Espacio -->
						<div class="form-group">
							<label class="control-label col-lg-2" for="id_espacio">Espacio</label>
							<div class="col-lg-10">
								<form:select id="selectorEspacioCrear" path="id_espacio">
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
								<form:input id="inputFechaInicio" path="fechaInicio" />
							</div>
						</div>

						<!-- Fin Reserva -->
						<div class="form-group fecha">
							<label class="control-label col-md-2" for="fechaFin"><spring:message
									code="editor.reservas.fin" /></label>
							<div class="col-md-2">
								<form:input id="inputFechaFin" path="fechaFin" />
							</div>
						</div>

					</div>


					<div class="modal-footer">
						<!-- Botón crear aviso -->
						<div class="form-group add">
							<div class="col-lg-offset-2 col-lg-10">
								<input type="submit" id="btnAdd" class="btn btn-primary"
									value="<c:out value="${modo}"></c:out>	" />
							</div>
						</div>
					</div>


				</fieldset>
			</form:form>

		</div>
	</div>
</div>

<div class="modal fade" id="modalEditarReserva" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">
					<c:out value="${modo}"></c:out>
					<spring:message code="editor.reservas.reserva" />
				</h4>
			</div>
			<form:form action="${postURLactualizar}" modelAttribute="reserva"
				class="form-horizontal" method="${methodActualizar}">
				<form:errors path="*" cssClass="alert alert-danger" element="div" />

				<c:if test="${! empty error}">
					<div class="alert alert-danger">
						¡Error!
						<c:out value="${error}" />
					</div>
				</c:if>


				<fieldset>

					<div class="modal-body">
						<div class="alert alert-warning">
							<spring:message code="editor.reservas.nota.fechas" />
						</div>


						<!-- Espacio -->
						<div class="form-group">
							<label class="control-label col-lg-2" for="id_espacio">Espacio</label>
							<div class="col-lg-10">
								<form:select id="selectorEspacio" path="id_espacio">
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
								<form:textarea id="aclaracionesTexto" path="aclaraciones"
									type="text" class="form:input-large" />
							</div>
						</div>

						<!-- Comienzo Reserva-->
						<div class="form-group fecha">
							<label class="control-label col-md-2" for="fechaInicio"><spring:message
									code="editor.reservas.comienzo" /> </label>
							<div class="col-md-2">
								<form:input id="inputFechaInicioEditar" path="fechaInicio" />
							</div>
						</div>

						<!-- Fin Reserva -->
						<div class="form-group fecha">
							<label class="control-label col-md-2" for="fechaFin"><spring:message
									code="editor.reservas.fin" /></label>
							<div class="col-md-2">
								<form:input id="inputFechaFinEditar" path="fechaFin" />
							</div>
						</div>

					</div>


					<div class="modal-footer">
						<!-- Botón crear aviso -->
						<div class="form-group add">
							<div class="col-lg-offset-2 col-lg-10">
								<input type="submit" id="btnAdd" class="btn btn-primary"
									value="<c:out value="${modo}"></c:out>	" />
							</div>
						</div>
					</div>


				</fieldset>
			</form:form>

		</div>
	</div>
</div>

<div class="modal fade" id="modalDatosEvento" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div id="fechaEventoDesde"></div>
	<div id="fechaEventoHasta"></div>
</div>


<script>
<!-- Date & Time picker -->
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
		$("#inputFechaInicioEditar").datetimepicker({
			format : 'Y/m/d H:i',
			step : 15,
			minDate : '0',
			onChangeDateTime : logic,
			onShow : logic,
			onSelectDate : logicWeekends
		});
		$('#inputFechaFinEditar').datetimepicker({
			format : 'Y/m/d H:i',
			step : 15,
			minDate : '0',
			onChangeDateTime : logic,
			onShow : logic,
			onSelectDate : logicWeekends
		});
		$("#inputFechaInicio").datetimepicker({
			format : 'Y/m/d H:i',
			step : 15,
			minDate : '0',
			onChangeDateTime : logic,
			onShow : logic,
			onSelectDate : logicWeekends
		});
		$('#inputFechaFin').datetimepicker({
			format : 'Y/m/d H:i',
			step : 15,
			minDate : '0',
			onChangeDateTime : logic,
			onShow : logic,
			onSelectDate : logicWeekends
		});
	});
</script>



<script>
	//Devuelve la correcta selección de eventos
	function seleccionarEventos(reservasFormatoJson, idSeleccion) {

		var eventos = [];

		console.log("idSeleccion: " + idSeleccion);
		if (idSeleccion == "todos") {
			var arrayLength = reservasFormatoJson.length;
			for ( var tipoEspacio in reservasFormatoJson) {
				var eventosLength = reservasFormatoJson[tipoEspacio].length;
				for (var evento = 0; evento < eventosLength; evento++) {
					eventos.push(reservasFormatoJson[tipoEspacio][evento]);
				}
			}
		} else {
			eventos = reservasFormatoJson[idSeleccion];
		}
		console.log("eventos: " + eventos);

		return eventos;
	}

	var reservasJSON = [];

	<c:forEach items="${reservas}" var="reserva">
	if (!reservasJSON['${reserva.espacio.id}']) {
		reservasJSON['${reserva.espacio.id}'] = [];
	}

	var datosReserva = new Object();

	datosReserva.title = "<joda:format value="${reserva.fechaFin}" pattern="HH:mm" />"
			+ "\n" + "${reserva.espacio.nombre}" + "\n" + "${reserva.titular}";
	datosReserva.start = "${reserva.fechaInicio}";
	datosReserva.end = "${reserva.fechaFin}";
	datosReserva.aclaraciones = "${reserva.aclaraciones}";
	datosReserva.idReserva = "${reserva.id}";
	datosReserva.espacio = "${reserva.espacio.id}";
	datosReserva.allday = false;
	reservasJSON['${reserva.espacio.id}'].push(datosReserva);

	</c:forEach>

	/* Debug */
	console.log("reservasJSON: " + reservasJSON);

	var idSeleccionado = "todos";
	var eventos = seleccionarEventos(reservasJSON, idSeleccionado);

	/* Debug */
	console.log("Eventos primerors:" + eventos);

	$(document)
			.ready(
					function() {

						// page is now ready, initialize the calendar...

						$('#calendar')
								.fullCalendar(
										{
											defaultView: 'agendaWeek',
											header : {
												left : 'prev,next today',
												center : 'title',
												right : 'month,agendaWeek,agendaDay'
											},
											eventClick : function(calEvent,
													jsEvent, view) {
												$('#modalEditarReserva').modal(
														'show');
												$(
														'#modalEditarReserva #aclaracionesTexto')
														.text(
																calEvent.aclaraciones);
												$(
														'#modalEditarReserva #inputFechaInicioEditar')
														.attr(
																"value",
																calEvent.end
																		.format("YYYY/MM/DD HH:mm"));
												$(
														'#modalEditarReserva #inputFechaFinEditar')
														.attr(
																"value",
																calEvent.end
																		.format("YYYY/MM/DD HH:mm"));

												$("#selectorEspacio").val(
														calEvent.espacio);
												$("#modalEditarReserva form")
														.attr(
																"action",
																"${postURLactualizar}"
																		+ calEvent.idReserva);

											},

											// Habilita popovers
											eventRender : function(event,
													element) {
												element
														.popover({
															title : "<b>"
																	+ event.aclaraciones
																	+ "</b>",//title: "My Title",
															placement : 'auto',
															html : true,
															trigger : 'hover',
															animation : 'true',
															content : event.msg
														});
												$('body')
														.on(
																'hover',
																function(e) {
																	if (!element
																			.is(e.target)
																			&& element
																					.has(e.target).length === 0
																			&& $(
																					'.popover')
																					.has(
																							e.target).length === 0)
																		element
																				.popover('hide');
																});
											},

											//Habilita creación de eventos seleccionando horas con el ratón
											selectable : true,

											select : function(start, end) {
												$('#modalCrearReserva').modal(
														'show');
												var eventData;
												$("#inputFechaInicio")
														.attr(
																"value",
																start
																		.format("YYYY/MM/DD HH:mm"));
												$("#inputFechaFin")
														.attr(
																"value",
																end
																		.format("YYYY/MM/DD HH:mm"));

												if (idSeleccionado != "todos") {
													$("#selectorEspacioCrear")
															.val(idSeleccionado);
												} else {
													$(
															'#selectorEspacioCrear option:first-child')
															.attr("selected",
																	"selected");
												}

												eventData = {
													start : start,
													end : end,
												};

												//Desmarca el evento si no se ha creado
												$('#calendar').fullCalendar(
														'unselect');
											},

											// Pasando los eventos con una función, pueden recargarse al cambiar la selección de espacio
											events : function(start, end,
													timezone, callback) {
												var eventosGenerados = seleccionarEventos(
														reservasJSON,
														idSeleccionado);
												callback(eventosGenerados);
											},

										})

					});

	//Configura la acción cuando se cambia la selección de espacio
	$("#selectorEspaciosGlobal").change(
			function() {
				console
						.log($("#selectorEspaciosGlobal option:selected")
								.text());
				console.log(reservasJSON[$("#selectorEspaciosGlobal").val()]);
				$("#calendar").fullCalendar('removeEventSource', eventos);
				idSeleccionado = $("#selectorEspaciosGlobal").val();
				console.log("Nuevos eventos:"
						+ reservasJSON[$("#selectorEspaciosGlobal").val()]);
				$("#calendar").fullCalendar('refetchEvents');
			});
</script>