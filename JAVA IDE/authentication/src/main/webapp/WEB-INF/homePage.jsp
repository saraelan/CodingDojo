<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
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
<body><div>
	<h1>Welcome, <c:out value="${user.email}" /></h1>
	<a href="/logout">Logout</a>
	<a href="/registration">Registration</a>
	
	
	</div>
	
</body>
</html>