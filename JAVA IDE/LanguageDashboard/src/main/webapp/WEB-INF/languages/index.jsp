<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Language Dashboard</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<style>
div{
margin: auto;
    width: 30%;
    border: 3px solid green;
    padding: 10px;

}
</style>
</head>
<body>
	<div class="list">
		<h1>Language Dashboard -List of Languages</h1>
		
		<table class="centered stripped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Action</th>
				</tr>
			</thead>
			
			
			<tbody>
				<c:forEach items="${lang}" var="l" varStatus="idx">
				
					<tr>
						<td><a href="/languages/${l.id}">
						<c:out value="${l.name}"/></a></td>
						<td><c:out value="${l.creator}"/></td>
						<td><c:out value="${l.version}"/></td>
						<td>
						
						
							<form action="/languages/${l.id}" method="post">
							
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="Delete">
							    
							</form>
							
							|<a href="/languages/${l.id}/edit">Edit</a>|
							
						</td>
					</tr>
					
					
					
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br><br>
	<div class= "form">
	<form:form action="/languages" method="POST" modelAttribute="language">		
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</p>
		<p>
			<form:label path="creator">Creator</form:label>
			<form:errors path="creator"/>
			<form:input path="creator"/>
		</p>
		<p>
			<form:label path="version">Version</form:label>
			<form:errors path="version"/>
			<form:input path="version"/>
		</p>
		<button class="btn waves-effect waves-light" type="submit" name="submit">Submit</button>
		
		</form:form>
	</div>		
	
</body>
</html>