<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>
<section class="container">
	<table id="avisos" class="table table-hover">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Aforo</th>
				<th>Tipo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${espacios}" var="item">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="caption">
						<tr>
							<td>${item.nombre}</td>
							<td>${item.aforo}</td>
							<td>${item.tipoEspacio}</td>
						</tr>
					</div>
				</div>
			</c:forEach>
		</tbody>
	</table>
</section>
<script type="text/javascript">
	$(document).ready(function() { /* Se deshabilita el orden por estos campos */
		$('#myModal').modal({
			show : false,
			keyboard : false
		});
		$('#avisos').DataTable({
			"aoColumnDefs" : [ {
				'bSortable' : false,
				'aTargets' : [ 7 ]
			}, //info
			{
				'bSortable' : false,
				'aTargets' : [ 8 ]
			}, //editar
			{
				'bSortable' : false,
				'aTargets' : [ 9 ]
			} //eliminar
			],

			//Cambio de texto de menus
			"language" : {
				"lengthMenu" : "Mostrar _MENU_ resultados por pagina",
				"zeroRecords" : "No se ha encontrado ningun resultado",
				"info" : "Página _PAGE_ de _PAGES_",
				"infoEmpty" : "No hay información",
				"infoFiltered" : "(filtado de _MAX_ resultados totales)",
				"search" : "Buscar:",
				"paginate" : {
					"first" : "Primera",
					"last" : "Ultima",
					"next" : "Siguiente",
					"previous" : "Anterior"
				},
			}
		});
	});
</script>