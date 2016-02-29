<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>

<c:url var="home" value="/" scope="request" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	
<!-- Latest compiled and minified CSS -->	
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

</head>
	
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

			<div id="ajaxresponse"></div>
			
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#id</th>
						<th>name</th>
						<th>phone</th>
						<th>email</th>
						<th>search books</th>
					</tr>
				</thead>
				<c:forEach var="customer" items="${customers}">
					<tr>
						<td>${customer.id}</td>
						<td>${customer.name}</td>
						<td>${customer.phone}</td>						
						<td>${customer.email}</td>
						<td>
							<button type="submit" class="btn btn-primary btn-lg" onclick="searchViaAjax(${customer.id});">Search</button>
						</td>
					</tr>
				</c:forEach>
			</table>

		</div>



<script>

 function searchViaAjax(customer_id) {
		var search = {}
		search["id"] = customer_id;
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${home}getajax",
			data : JSON.stringify(search),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				display(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	}

	function display(data) {
		var json = JSON.stringify(data, null, 4) + "<br>";
		$('#ajaxresponse').html(json);
	}
</script>
		
	</body>
</html>
