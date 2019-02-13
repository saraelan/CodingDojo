<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Language</title>
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
	<div class="navigation">
		<a href="/languages">Dashboard</a>
	</div>
	<br>
	<div class="show">
		<h1><c:out value="${lang.name}"/></h1>
		<h2><c:out value="${lang.creator}"/></h2>
		<h2><c:out value="${lang.version}"/></h2>
	</div>
	<br>
	<div class="navigation">
		|<a href="/languages/${lang.id}/edit">Edit</a> |
		
		<form action="/languages/${lang.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete">
		</form>


		
	</div>
</body>
</html>