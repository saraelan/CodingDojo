<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
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
<div>
<h1><c:out value="${category.name}"/></h1>
<table class="table">
    <thead>
        <tr>
            <th>Product</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${category.products}" var="l">
        <tr>
            <td><c:out value="${l.name}"/></td>
            
        </tr>
        </c:forEach>
    </tbody>
</table>
<form action="/categories/${category.id}/add" method="POST">
    <select name="product">
        <option value="none">--Select--</option>
    	<c:forEach items="${products}" var="product">
	        <option value="${product.id}">${product.name}</option>
        </c:forEach>
    </select>
    <button type="submit">Add</button>
</form></div>
</body>
</html>