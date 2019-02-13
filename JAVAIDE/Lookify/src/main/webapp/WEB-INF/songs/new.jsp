<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<title>Add New Songs</title>

</head>
<body>

<p style = "color:red">${errors }</p>

   <form:form method="POST" action="/songs/new" modelAttribute="song">
    
	    <form:label path="title">Name
	    <form:errors path="title"/>
	    <form:input path="title"/></form:label>
	    
	    <form:label path="artist">Artist
	    <form:errors path="artist"/>
	    <form:input path="artist"/></form:label>
	    
	    <form:label path="rating">Rating(1-10)
	    <form:errors path="rating"/>
	    <form:input type = "number" min = "1" max = "10" path="rating"/></form:label>
	    
	    <input type="submit" value="Add Song"/>
	    
	    
	</form:form>
	
	<h3><a href = "/dashboard">Dashboard</a></h3>	
</body>
</html>