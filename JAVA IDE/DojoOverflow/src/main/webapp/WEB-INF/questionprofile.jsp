<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Question Profile</title>
</head>
<body>
	<h1>${question.question}</h1>
	<h3>Tags: 
		<c:forEach items="${question.getTags()}" var="tag" varStatus="loop">
			${tag.subject}<c:if test="${loop.index < question.getTags().size()-1}">, </c:if>
		</c:forEach>
	</h3>
	
	<c:if test="${!empty answers}">
		<b>Answers</b>
		<ul>
			<c:forEach items="${answers}" var="answer">
				<li><c:out value="${answer.answer}"/></li>
			</c:forEach>
		</ul>
	</c:if>
	
	<h2>Add your answer: </h2>
	<form:form method="POST" action="/questions/${question.id}" modelAttribute="a">
	    <form:hidden path="question" value="${question.id}"/>
	    
	    <form:label path="answer">Answer: 
	    <br>
	    <form:errors path="answer"/>
	    <form:textarea path="answer"/></form:label>
	    <br><br>
	    <input type="submit" value="Answer it!"/>
	</form:form>
	
	<p><a href="/questions">Dashboard</a></p>
</body>
</html>