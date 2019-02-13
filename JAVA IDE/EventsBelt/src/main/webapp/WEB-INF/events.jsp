<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Events</title>
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
<h1>Welcome  <c:out value="${user.firstName}" /></h1>
<p>Here are some of the events from your state</p>

 <c:if test="${localEvents.isEmpty()}">
    	<h4>No events in your state</h4>
    </c:if>
    
    <c:if test="${!localEvents.isEmpty()}">
    
	<table class="table">
    <thead>
        <tr>
            <th>Name</th>
            <th>Date</th>
            <th>Location</th>
            <th>Host</th>
            <th>Actions</th>
        </tr>
    </thead>
    
    
    <c:forEach items="${localEvents}" var="event">
        <tr>
            <td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
            <td><fmt:formatDate pattern="MMMMMMM dd, yyyy" value="${event.date}" /></td>
            <td><c:out value="${event.city}"/></td>
            <td><c:out value="${event.p.firstName}"/></td>
            <td>
            	<c:if test="${event.p.id.equals(user.id)}">
            		<a href="/events/${event.id}/edit">Edit</a>
            		<a href="/events/${event.id}/delete">Delete</a>
            	</c:if>
            	<c:if test="${!event.p.id.equals(user.id)}">
            	
            		<c:if test="${!event.joiners.contains(user)}">
            			<a href="/events/${event.id}/join">Join</a>
            		</c:if>
            		<c:if test="${event.joiners.contains(user)}">
            			<p>Joining</p>
            			<a href="/events/${event.id}/cancel">Cancel</a>
            		</c:if>
            	
            	</c:if>            
            </td>
        </tr>
        </c:forEach>
    </tbody>
  	</table>
    </c:if>
    
<h2>Other Events</h2>
<p>Here are some of the events from your state</p>
    <c:if test="${notEvents.isEmpty()}">
    	<h4>No events outside your state</h4>
    </c:if>
    <c:if test="${!notEvents.isEmpty()}">
	<table class="table">
    <thead>
        <tr>
            <th>Name</th>
            <th>Date</th>
            <th>Location</th>
            <th>Host</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${notEvents}" var="event">
        <tr>
            <td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
            <td><fmt:formatDate pattern="MMMMMMM dd, yyyy" value="${event.date}" /></td>
            <td><c:out value="${event.city}"/>, <c:out value="${event.state}"/></td>
            <td><c:out value="${event.p.firstName}"/></td>
            <td>
            	<c:if test="${event.p.id.equals(user.id)}">
            		<a href="/events/${event.id}/edit">Edit</a>
            		<a href="/events/${event.id}/delete">Delete</a>
            	</c:if>
            	<c:if test="${!event.p.id.equals(user.id)}">
            		<c:if test="${!event.joiners.contains(user)}">
            			<a href="/events/${event.id}/join">Join</a>
            		</c:if>
            		<c:if test="${event.joiners.contains(user)}">
            			<p>Joining <a href="/events/${event.id}/cancel">Cancel</a></p>
            		</c:if>
            	</c:if>  
            </td>
        </tr>
        </c:forEach>
    </tbody>
    </table>
    </c:if>
<h2>New Event</h2>
    <form:form method="POST" action="/events" modelAttribute="event">
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
        <p>
            <form:label path="date">Date:</form:label>
            <form:input type="date" path="date"/>
            <form:errors path="date" class="red"/>
        </p>
	<form:input type="hidden" path="p" value="${user.id}"/>
        <input type="submit" value="Add New Event"/>
    </form:form></div>
    <br>
    <a href="/logout">Logout</a>
</body>
</html>