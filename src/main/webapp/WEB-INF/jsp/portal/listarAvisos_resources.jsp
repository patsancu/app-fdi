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
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="<spring:url value="/webjars/datatables/1.10.4/js/jquery.dataTables.min.js" />"></script>

<link rel="stylesheet" type="text/css"
	href="<spring:url value="/webjars/datatables-plugins/ca6ec50/integration/bootstrap/3/dataTables.bootstrap.css" />">
<script type="text/javascript"
	src="<spring:url value="/webjars/datatables-plugins/ca6ec50/integration/bootstrap/3/dataTables.bootstrap.js" />"></script>