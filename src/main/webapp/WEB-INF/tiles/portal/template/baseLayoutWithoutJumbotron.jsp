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
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initialscale=
1.0">
<link rel="stylesheet"
	href="<c:url value="/webjars/bootstrap/3.0.0/css/bootstrap.min.css" />" >
<script src="<c:url value="/webjars/jquery/2.1.1/jquery.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/webjars/bootstrap/3.0.0/js/bootstrap.min.js" />"></script>

<link rel="stylesheet" href="<c:url value="/static/css/globalStyle.css" />">

<tiles:insertAttribute name="resources" />



<c:set var="titleKey">
	<tiles:insertAttribute name="title" />
</c:set>
<c:if test="${! empty titleKey}">
	<title><spring:message code="${titleKey}"></spring:message></title>
</c:if>

</head>
<body>
	<div class="container">
		<div class="header">
			<ul class="nav nav-pills pull-right">
				<tiles:insertAttribute name="navigation" />
			</ul>
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