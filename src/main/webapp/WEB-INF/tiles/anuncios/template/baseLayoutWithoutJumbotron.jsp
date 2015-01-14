<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initialscale=
1.0">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript"
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>



<c:url var="cssGlobal" value="/static/css/globalStyle.css" />
<link rel="stylesheet" href="${cssGlobal}">
</head>



<body>
	<div class="container">
		<div class="header">
			<ul class="nav nav-pills pull-right">
				<tiles:insertAttribute name="navigation" />
			</ul>
			<!-- <h3 class="text-muted">Aplicación FdI-UCM</h3> -->
		</div>

		<div class="row">
			<tiles:insertAttribute name="content" />
		</div>
		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>