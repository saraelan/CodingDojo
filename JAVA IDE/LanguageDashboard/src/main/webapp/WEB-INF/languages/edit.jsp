<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Language</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<style>
div{
margin: auto;
    width: 50%;
    border: 3px solid green;
    padding: 10px;

}
</style>
</head>
<body>

	<div class="nav">
		<form action="/languages/${lang.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>
		
		
	  |	<a href="/languages">Dashboard</a> |
		
	
	</div>
	<br>
	<div class="form">
		<form:form action="/languages/${lang.id}" method="post" modelAttribute="lang">
			<input type="hidden" name="_method" value="put">
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