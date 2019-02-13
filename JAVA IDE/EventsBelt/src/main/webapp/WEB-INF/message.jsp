<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Event</title>
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
		<h1><c:out value="${event.name}"/></h1>
		<p>Host: <c:out value="${event.p.firstName}"/> <c:out value="${event.p.lastName}"/></p>	
		<p>Date: <fmt:formatDate pattern="MMMMMMM dd, yyyy" value="${event.date}" /></p>	
		<p>Location: <c:out value="${event.city}"/>, <c:out value="${event.state}"/></p>	
		<p>People who are joining this trip: <c:out value="${event.joiners.size()}"/></p>
		
		<c:if test="${!event.joiners.isEmpty()}">
		<table class="table">
	    <thead>
	        <tr>
	            <th>Name</th>
	            <th>Location</th>
	        </tr>
	    </thead>
	    <tbody>
	        <c:forEach items="${event.joiners}" var="join">
	        <tr>
	            <td><c:out value="${join.firstName}"/> <c:out value="${join.lastName}"/></td>
	            <td><c:out value="${join.city}"/></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	  	</table>
	</c:if>
	</div>
	
    <div class="box">
    	<h2>Message Wall:</h2>
    	<c:forEach items="${event.messages}" var="message">
    		<p><c:out value="${message.p.firstName}"/> <c:out value="${message.p.lastName}"/>: <c:out value="${message.text}"/></p>
    	</c:forEach>
    	
	    <form:form method="POST" action="/events/${event.id}/message" modelAttribute="message">
	        <form:label path="text">Add comments:</form:label>
	        <p>
	            <form:textarea path="text"/>
	            <form:errors path="text" class="red"/>
	        </p>
	        <form:input type="hidden" path="p" value="${user.id}"/>
	        <form:input type="hidden" path="event" value="${event.id}"/>
	        <input type="submit" value="New Submit"/>
	    </form:form>
	    
	    <br>
	    <a href="/events"> Event Home</a>|<a href="/logout">Logout</a>
	    
    </div>





</body>
</html>