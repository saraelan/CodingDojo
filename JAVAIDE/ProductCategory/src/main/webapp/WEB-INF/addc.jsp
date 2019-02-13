<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<title>New CAtegory</title>
<style>
div{
	margin: auto;
    width: 50%;
    border: 3px solid green;
    padding: 10px;

}
.red
{
color:black;

}



</style>
</head>
<body>
<div>
<h1>New Category</h1>
<form:form action="/categories/new" method="post" modelAttribute="category">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name" class="red"/>
        <form:input path="name" class="form-control"/>
    </p>  
    <input type="submit" value="Submit" class="btn"/>
</form:form>   </div>
</body>
</html>