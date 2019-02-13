<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
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
<h1>Edit Event</h1>
<h1>${event.name}</h1>
<form:form action="/events/${event.id}" method="post" modelAttribute="event">
<input type="hidden" name="_method" value="put">
 <p>
         <form:label path="name">Name:</form:label>
         <form:input path="name"/>
         <form:errors path="name" class="red"/>
     </p>
     <p>
         <form:label path="city">Location:</form:label>
         <form:input path="city"/>
         <form:errors path="city" class="red"/>
     </p>
     <p>
         <form:label path="state">State:</form:label>
            <form:select path="state">
                <form:option value="${user.state}" />
            
                <c:forEach items="${states}" var="state">
                    <form:option value="${state}">${state}</form:option>
                </c:forEach>
            </form:select>
     </p>
     <p>
         <form:label path="date">Date:</form:label>
         <form:input type="date" path="date"/>
         <form:errors path="date" class="red"/>
     </p>
 <form:input type="hidden" path="p" value="${event.p.id}"/>
        <input type="submit" value="Update"/>
        
</form:form></div>
</body>
</html>