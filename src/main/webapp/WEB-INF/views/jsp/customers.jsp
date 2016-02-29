<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

	<body>

		<div class="container">

			<c:if test="${not empty msg}">
				<div class="alert alert-${css} alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert" 
                            aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<strong>${msg}</strong>
				</div>
			</c:if>

			<h1>customers</h1>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>#id</th>
						<th>name</th>
						<th>phone</th>
						<th>email</th>
					</tr>
				</thead>
				<c:forEach var="customer" items="${customers}">
					<tr>
						<td>${customer.id}</td>
						<td>${customer.name}</td>
						<td>${customer.phone}</td>						
						<td>${customer.email}</td>
					</tr>
				</c:forEach>
			</table>

		</div>

	</body>
</html>
