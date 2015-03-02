<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel='stylesheet'
	href='http://cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.3.0/fullcalendar.min.css' />
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment.min.js'></script>
<link rel='stylesheet'
	href='http://cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.3.0/fullcalendar.min.css'></link>
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.3.0/fullcalendar.min.js'></script>
<!-- //cdnjs.cloudflare.com/ajax/libs/fullcalendar/2.3.0/fullcalendar.print.css  -->
<script type="text/javascript">
	$(document).ready(function() {

		// page is now ready, initialize the calendar...

		$('#calendar').fullCalendar({
			dayClick : function() {
				alert('a day has been clicked!');
			},
			events : [ 
						<c:forEach items="${reservas}" var="item">
							{
								title: "${item.titular}",
								start: "${item.fechaInicio}",
								end: "${item.fechaFin}",
								allday: false
							},
						</c:forEach>
			  ]
		})

	});
</script>