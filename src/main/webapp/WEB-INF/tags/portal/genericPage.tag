<%@ tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="elemento" tagdir="/WEB-INF/tags/portal/elementos"%>
<%@ attribute name="cabecera" fragment="true" %>
<%@ attribute name="titulo" required="true" %>
<html>


<head>
	<!-- INCLUDES -->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet"
		href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$('#myModal').modal({
			show : false,
			keyboard : false
		});
	</script>
	<title>
		${titulo}
	</title>
</head>

<body>
	<div id="pageheader">
		<jsp:invoke fragment="cabecera"/>
	</div>
	<div id="body">
		<jsp:doBody/>
	</div>
	<div id="pagefooter">
		<%-- <jsp:invoke fragment="pie"/> --%>
		<elemento:pie></elemento:pie>
	</div>
</body>
</html>