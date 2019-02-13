<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New product</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<style>
div{
	margin: auto;
    width: 50%;
    border: 3px solid green;
    padding: 10px;

}

.red
{
color:red;

}


</style>
</head>
<body>
<div>
<h1> New product</h1>
<form:form action="/products/new" method="post" modelAttribute="product">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name" class="red"/>
        <form:input path="name" class="form-control"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description" class="red"/>
        <form:input path="description" class="form-control"/>
    </p>
    <p>
        <form:label path="price">Price</form:label>
        <form:errors path="price" class="red"/>
        <form:input type="number" path="price" class="form-control"/>
    </p>    
    <input type="submit" value="Submit" class="btn"/>
</form:form></div>   
</body>
</html>