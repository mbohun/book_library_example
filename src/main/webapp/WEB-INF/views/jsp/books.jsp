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

			<h1>books</h1>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>#isbn</th>
						<th>author</th>
						<th>title</th>
					</tr>
				</thead>
				<c:forEach var="book" items="${books}">
					<tr>
						<td>${book.isbn}</td>
						<td>${book.author}</td>
						<td>${book.title}</td>						
					</tr>
				</c:forEach>
			</table>

		</div>

	</body>
</html>
