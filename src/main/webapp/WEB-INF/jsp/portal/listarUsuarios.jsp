<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags"%>
<section class="container">
	<table id="espacios" class="table table-hover">
		<thead>
			<tr>
				<th>Nombre de usuario</th>
				<th>Password</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="item">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px" >
					<div class="caption">
						<tr>
							<td>${item.username}</td>
							<td>${item.password}</td>
							<td>${item.email}</td>
						</tr>
					</div>
				</div>
			</c:forEach>
		</tbody>
	</table>
</section>