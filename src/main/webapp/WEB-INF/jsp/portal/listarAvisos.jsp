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
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />

<section class="container">
	<table id="avisos" class="table table-hover">
		<thead>
			<tr>
				<th><spring:message code="listado.prioridad"></spring:message></th>
				<th><spring:message code="listado.tipo"></spring:message></th>
				<th><spring:message code="listado.titulo"></spring:message></th>
				<th><spring:message code="listado.contenido.aviso"></spring:message></th>
				<th><spring:message code="listado.etiqueta"></spring:message></th>
				<th><spring:message code="listado.tweet"></spring:message></th>
				<th><spring:message code="listado.autor"></spring:message></th>
				<th><spring:message code="listado.fecha.creacion"></spring:message></th>
				<th><spring:message code="listado.fecha.publicacion.comienzo"></spring:message></th>
				<th><spring:message code="listado.fecha.publicacion.fin"></spring:message></th>
				<th><spring:message code="listado.twitter"></spring:message></th>
				<th><spring:message code="listado.acciones"></spring:message></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${avisos}" var="item">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="caption">
					<tr>
						<td><c:if test="${item.prioridadAviso.description eq 'IMPORTANTE'}">
								<span class=" glyphicon glyphicon-exclamation-sign"></span>
							</c:if></td>
						<td>
							<!-- Tipo de destino: Post, URL o archivo adjunto --> <c:choose>
								<c:when test="${item.tipoAviso.name() eq 'POST'}">
									<a
										href="<spring:url value="/avisos/{id}/ver"><spring:param name="id" value="${item.id}" /></spring:url>" class="btn btn-primary"> <span
										class="glyphicon glyphicon-info-sign"></span>
									</a>
								</c:when>
								<c:when test="${item.tipoAviso.name() eq 'URL'}">
									<a href="${item.urlDestino}" class="btn btn-primary" target="_blank"> <span
										class="glyphicon glyphicon-info-sign"></span>
									</a>
								</c:when>
								<c:when test="${item.tipoAviso.name() eq 'ADJUNTO'}">
									<a
										href="${item.adjunto}"
										class="btn btn-primary"> <span
										class="glyphicon glyphicon-info-sign"></span>
									</a>
								</c:when>
								<c:otherwise>
									<a
										href="<spring:url value="/avisos/{id}/ver"><spring:param name="id" value="${item.id}" /></spring:url>"
										class="btn btn-primary"> <span
										class="glyphicon glyphicon-info-sign"></span>
									</a>
								</c:otherwise>
							</c:choose>
						</td>
						<td>${item.titulo}</td>
						<td>
						
						
						${fn:substring(item.contenidoAviso, 0, 23)}
							<c:if test="${fn:length(item.contenidoAviso) gt 23 }">
							
							
								<button id="popover${item.id}" type="button" class="btn btn-default"
										data-container="body" data-toggle="popover" data-trigger="focus"
										data-placement="top">
										...
								</button>
								<script>
									$('#popover${item.id}').popover({
										html:'true',
										title: "${item.titulo}",
										content: "${item.contenidoAviso}",
										template:
											'<div class="popover" style=" overflow: auto;" role="tooltip">' +
											'<div class="arrow"></div><h3 class="popover-title"></h3>' +
											'<div class="popover-content"></div></div>'
									});
								</script>
							</c:if>
						</td>
						
						<td>${item.etiqueta}</td>
						<td>
							<c:if test="${ item.idTweetAsociado > 0 }">
								<a href="${urlTwitterUsuario}${item.idTweetAsociado}">
									Tweet
								</a>
							</c:if>
						</td>
						<td>${item.autor.username}</td>
						<td><joda:format value="${item.fechaCreacion}" pattern="yyyy/MM/dd HH:mm" /></td>
						<td><joda:format value="${item.comienzoPublicacion}" pattern="yyyy/MM/dd HH:mm" /></td>
						<td><joda:format value="${item.finPublicacion}" pattern="yyyy/MM/dd HH:mm" /></td>						
						
						<td>
							<img id="${item.id}" class="botonTweet" alt="Tweet" src="<spring:url value="/static/img/twitter.png" />" width="30"> 
						</td>						
						
						<td><a class="btn btn-success"
							href="<spring:url value="/avisos/{id}"><spring:param name="id" value="${item.id}" /></spring:url>">
								<span class="glyphicon glyphicon-edit"></span>
						</a>
						<form:form action="${deleteAction}/${item.id}" method="DELETE">
							<!-- Botón eliminar -->
							<button type="button" class="btn btn-danger" data-toggle="modal"
								data-target=".bs-delete-modal-sm${item.id}">
								<span class="glyphicon glyphicon-remove"></span>
							</button> <!-- Popup de confirmación de eliminación -->
							<div class="modal fade bs-delete-modal-sm${item.id}"
								tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel"
								aria-hidden="true">
								<div class="modal-dialog modal-sm">
									<div class="modal-content">
										<div class="modal-header bg-primary">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel"><spring:message code="listado.acciones.eliminar.anuncio"></spring:message></h4>
										</div>										
										<div class="modal-body"><spring:message code="listado.acciones.eliminar.warning"></spring:message></div>
										<div class="modal-footer ">
											<button type="submit" class="btn btn-danger"><spring:message code="listado.acciones.eliminar">"${item.titulo}"?</spring:message></button>											
											<button type="button" class="btn btn-warning " data-dismiss="modal"><spring:message code="listado.acciones.cancelar"></spring:message></button>
										</div>
									</div>
								</div>
							</div> <!-- Fin de  Popup de confirmación de eliminación -->
						</form:form>
						</td>
					</tr>
				</div>
			</div>
		</c:forEach>
		</tbody>
	</table>

	<!-- Popup de confirmación de tweet -->
	<div id="modalTweetCreado" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">
						<spring:message code="listado.twitter.tweet.crear"></spring:message>						
					</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label><spring:message code="listado.twitter.tweet.publicacion"></spring:message></label>
						
						<p  style="overflow:auto;resize: vertical;" id="textoTweet" contenteditable="false" class="form-control"  id="comment"></p>
						<div id="caracteresRestantes"></div>
					</div>
					<div id="resultadoTweet"></div>
				</div>
				<div class="modal-footer ">
					<div class="btn-group" role="group" aria-label="...">
					<button id="botonEditarTweet" type="button" class="btn btn-warning ">
						<spring:message code="listado.twitter.tweet.editar"></spring:message>
					</button>
					<button id="botonTuitear" type="button" class="btn btn-primary ">
						<spring:message code="listado.twitter"></spring:message>						
					</button>
					<button id="botonCerrar" type="button" class="btn btn-danger " data-dismiss="modal">
						<spring:message code="listado.twitter.tweet.cerrar"></spring:message>
					</button>
					</div>
				</div>
			</div>
		</div>
	</div>




</section>
<script type="text/javascript">
	$(document).ready(
		function() { /* Se deshabilita el orden por estos campos */
			$('#myModal').modal({
				show : false,
				keyboard : false
			});
			$('#avisos')
				.DataTable(
					{
						"aoColumnDefs" : 
						[
						 {
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
							"lengthMenu" : <spring:message code="listado.datatables.lengthmenu"></spring:message>,
							"zeroRecords" : <spring:message code="listado.datatables.zerorecords"></spring:message>,
							"info" : <spring:message code="listado.datatables.info"></spring:message>,
							"infoEmpty" : <spring:message code="listado.datatables.infoempty"></spring:message>,
							"infoFiltered" : <spring:message code="listado.datatables.infofiltered"></spring:message>,
							"search" : <spring:message code="listado.datatables.search"></spring:message>,
							"paginate" : {
								"first" : <spring:message code="listado.datatables.first"></spring:message>,
								"last" : <spring:message code="listado.datatables.last"></spring:message>,
								"next" : <spring:message code="listado.datatables.next"></spring:message>,
								"previous" : <spring:message code="listado.datatables.previous"></spring:message>
							},
						}
				});
		});
</script>

<!-- AJAX para tweetear -->
<script>


$(document).ready(
		function() {		
			
			$('#botonCerrar').click(function(event){
				location.reload();
			});
			
			$('#textoTweet').keydown(function(){
				var longitud = $('#textoTweet').text().length;
				console.log("Caracteres escritos: " + longitud);
				var caracteresRestantes = 140 - longitud;
				$('#caracteresRestantes').text(caracteresRestantes + " caracteres restantes");
				if (longitud >= 140){
					$('#textoTweet').attr('contenteditable', 'false');	
				}
			});
			
			$('#botonTuitear').click(  function(event) {				
				var header = $("meta[name='_csrf_header']").attr("content"); 
				var token = $("meta[name='_csrf']").attr("content"); console.log("Token " + token);
				var urlRest = '<spring:url value="${urlRESTbase}"></spring:url>' + $('.modal-footer').attr('id');
				var data = $('#textoTweet').text();				
				$('#resultadoTweet').attr('class', '');
				$('#resultadoTweet').text("");
				$.ajax({  					
					contentType: "application/json",
	 				url: urlRest,
	 				data: data,
	 				method: "POST",
					beforeSend : function( xhr ) { 
						xhr.setRequestHeader(header, token);
					},
					success: function(data){					
						
					},
					error:function(data, textStatus, jqXHR){
						alert("Error" + data);
					},
					complete:function(data, textStatus, jqXHR){
						if (data.responseText === ''){
							$('#resultadoTweet').attr('class', 'alert alert-danger');
							$('#resultadoTweet').text('<spring:message code="listado.twitter.tweet.error"></spring:message>');
						}
						else{							
							$('#resultadoTweet').attr('class', 'alert alert-success');
							$('#resultadoTweet').text('<spring:message code="listado.twitter.tweet.creado"></spring:message>');
						}
					},
				});
				
			});
			
			$('#botonEditarTweet').click(  function(event) {
				$('#resultadoTweet').attr('class', '');
				$('#resultadoTweet').text("");
				var longitud = $('#textoTweet').text().length;
				if (longitud < 140){
					$('#textoTweet').attr('contenteditable', 'true');
					console.log("Caracteres escritos: " + longitud);
					var caracteresRestantes = 140 - longitud;
					$('#caracteresRestantes').text( caracteresRestantes + " caracteres restantes");	
				}
				
			});
			
			$('.botonTweet').click(  function(event) {
				var header = $("meta[name='_csrf_header']").attr("content"); 
				var token = $("meta[name='_csrf']").attr("content");
				var urlRest = '<spring:url value="${urlRESTbase}"></spring:url>' + $(this).attr('id');
				var data = JSON.stringify($(this).attr('id'));
				$('.modal-footer').attr('id', $(this).attr('id'));
				$.ajax({  					
					contentType: "application/json",
	 				url: urlRest, 
	 				method: "GET",
					beforeSend : function( xhr ) { 
						xhr.setRequestHeader(header, token);
					},
					success: function(data){					
						
					},
					error:function(data, textStatus, jqXHR){
						alert("Error" + data + textStatus);
						console.log(data);
					},
					complete:function(data, textStatus, jqXHR){
						$('#textoTweet').text(data.responseText);
						$('#modalTweetCreado').modal('show');
					},
				});
			});  
		});
</script>