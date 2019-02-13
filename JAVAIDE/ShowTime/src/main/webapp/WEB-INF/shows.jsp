<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View a Show</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
<style>
div{
margin: auto;
    width: 50%;
    border: 3px solid green;
    padding: 10px;s

}
</style>

</head>

<body>
<div>
<h3>${show.showname}</h3>
<h5>Network: ${show.network }</h5>
<h3>User Who rated this show</h3>

<table class="table">
		<tr>
			<th>Name</th>
			<th>Rating</th>
		</tr>
		
		<c:forEach items="${rat}" var="e">
		<tr>
			<td><c:out value="${e.user.name}"></c:out></td>
			<td><c:out value="${e.rate}"></c:out></td>
		</tr>
		</c:forEach>
		
	</table>
	
	<a href="/shows/${show.id}/edit">Edit</a> | <a href="/shows">Back</a><br>
	
	<form:form action="/shows/${show.id}/rating" method="post" modelAttribute="r">
	
	
	
		<label>Leave a Rating</label>
		<form:select path="rate">
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		

		<form:input type="hidden" value="${show.id}" path="show"/>
		</form:select> 
			<button type="submit">Rate!!</button>
		</form:form>
	




</div>

</body>
</html>