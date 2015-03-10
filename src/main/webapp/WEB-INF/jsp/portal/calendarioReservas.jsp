<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>

<%-- <form:select path="tipoEspacio">
	<form:option value="-" label="Selecciona Uno" />
	<form:options items="${tiposEspacios}" />
</form:select> --%>

<script>
	function objectToString(o) {
		var parse = function(_o) {
			var a = [], t;
			for ( var p in _o) {
				if (_o.hasOwnProperty(p)) {
					t = _o[p];
					if (t && typeof t == "object") {
						a[a.length] = p + ":{ "
								+ arguments.callee(t).join(", ") + "}";
					} else {
						if (typeof t == "string") {
							a[a.length] = [ p + ": \"" + t.toString() + "\"" ];
						} else {
							a[a.length] = [ p + ": " + t.toString() ];
						}
					}
				}
			}
			return a;

		}
		return "{" + parse(o).join(", ") + "}";
	}

	var reservasJSON = [];

	<c:forEach items="${reservas}" var="reserva">
	if (!reservasJSON['${reserva.espacio.id}']) {
		reservasJSON['${reserva.espacio.id}'] = [];
	}

	var datosReserva = new Object();
	//datosReserva.id = "${reserva.id}";t
// 	datosReserva.title = "${reserva.titular}" + "\n" +  "${reserva.espacio.nombre}";
	
	datosReserva.title = "<joda:format value="${reserva.fechaFin}" pattern="HH:mm" />" + "\n" +  "${reserva.espacio.nombre}" + "\n" + "${reserva.titular}";
	datosReserva.start = "${reserva.fechaInicio}";
	datosReserva.end = "${reserva.fechaFin}";
	datosReserva.allday = false;
	reservasJSON['${reserva.espacio.id}'].push(datosReserva);

	</c:forEach>
	console.log(reservasJSON);

	var eventos = [];
	var arrayLength = reservasJSON.length;
	for ( var tipoEspacio in reservasJSON) {
		var eventosLength = reservasJSON[tipoEspacio].length;
		for (var evento = 0; evento < eventosLength; evento++) {
			eventos.push(reservasJSON[tipoEspacio][evento]);
		}

		//Do something
	}

	console.log(eventos);

	$(document).ready(
			function() {

				// page is now ready, initialize the calendar...

				$('#calendar').fullCalendar(
						{
// 							eventMouseover:
// 							function( event, jsEvent, view ) { 
// 								$('#modalDatosEvento').modal('show');
// 							},
							selectable : true,
							select : function(start, end) {
								$('#myModal').modal('show');
								//var title = prompt('Event Title:');
								var eventData;
								$("#inputFechaInicio").attr("value",
										start.format("YYYY/MM/DD HH:mm"));
								$("#inputFechaFin").attr("value",
										end.format("YYYY/MM/DD HH:mm"));

								eventData = {
									start : start,
									end : end,
									color: 'yellow'
								};
								$('#calendar').fullCalendar('renderEvent',
										eventData, true); // stick? = true

								$('#calendar').fullCalendar('unselect');
							},
							events : eventos
						// 			events : [ 
						// 						<c:forEach items="${reservas}" var="item">
						// 							{
						// 								title: "${item.titular}",
						// 								start: "${item.fechaInicio}",
						// 								end: "${item.fechaFin}",
						// 								allday: false
						// 							},
						// 						</c:forEach>
						// 			  ]
						})

			});
</script>

<div id='calendar'></div>


<c:url value="/reservas/nuevo" var="postURL" />

<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
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
			<form:form action="${postURL}" modelAttribute="reserva" class="form-horizontal"
				method="${method}">
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
<!-- 									<div id="botonCrear" class="btn btn-primary"> -->
<%-- 										<c:out value="${modo}"></c:out> --%>
<!-- 									</div> -->
							</div>
						</div>
					</div>


				</fieldset>
			</form:form>

		</div>
	</div>
</div>


<div class="modal fade" id="modalDatosEvento" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div id="fechaEventoDesde"></div>
	<div id="fechaEventoHasta"></div>
</div>


<script>
$("#botonCrear").click(function(){
	
	
    $.ajax({type:"post",url: "<spring:url value="/reservas/ajax/nueva" />", success: function(result){
    	alert("Success!");
        $("#div1").html(result);
    }});
}); 
</script>

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

	/* jQuery('#datetimepicker_rantime').datetimepicker({
		onChangeDateTime : logic,
		onShow : logic
	}); */
</script>