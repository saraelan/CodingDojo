<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<style>
div
{margin: auto;
    width: 50%;
    border: 3px solid green;
    padding: 10px;
}

h1
{text-align:center;
}
</style>

</head>
<body>
<h1>Dashboard Page!!!</h1>
		<div class ="form">
		<a href = "/songs/new">Add New</a> |
		
		<a href = "/songs/top">Top Songs</a>
		
		<form action="/search" method="post">
		<input type="text" name="search">
		<button type="submit">Search</button>
		</form>   
		
		<br>
		
	

	
	<table class="centered">
    	<tr>
    		<td>Title</td>
    		<td>Rating</td>
    		<td>Action</td>
    	</tr>
    <c:forEach items="${songs}" var="song" varStatus="loop">
        <tr>        
		    <td><a href = "/songs/${song.id}"><c:out value="${song.title}"/></a></td>
		    <td><c:out value="${song.rating}"/></td>
		    <td>
		    	<a href="/songs/delete/${song.id}">Delete</a>
		    </td>
        </tr>
    </c:forEach>
    </table></div>
</body>
</html>