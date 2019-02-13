<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Songs</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
</head>
<body>


<table class="centered">
    	<tr>
    		<td>Name</td>
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
    </table>
    <h3><a href = "/dashboard">Dashboard</a></h3>
</body>
</html>