<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All</title>
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

<h2> Welcome ${user.name} </h2>
<h4>TV Shows</h4>
<table class="table">
	<tr>
		<th>Show</th>
		<th>Network</th>
		<th>Avg Rating</th>
	</tr>
	<c:forEach items="${show}" var="s">
	<tr>
		<td>
			<a href="/shows/${s.id}"><c:out value="${s.showname}"></c:out></a>
		</td>
		<td><c:out value="${s.network}"></c:out></td>
		<c:if test="${s.avgRating == null}">
		<td>No rating given</td>
		</c:if>
		<c:if test="${s.avgRating != null}">
		<td><c:out value="${s.avgRating}"></c:out></td>
		</c:if>
	</tr>
	</c:forEach>
</table>

<a href="/shows/new">Add a Show</a>




</div>

</body>
</html>