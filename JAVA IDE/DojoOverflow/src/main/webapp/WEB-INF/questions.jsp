<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Questions Dashboard</title>
	<style>
		table {
		    border-collapse: collapse;
		    width: 100%;
		}
		
		td, th {
		    border: 1px solid #dddddd;
		    text-align: left;
		    padding: 8px;
		}
		
		tr:nth-child(even) {
		    background-color: #dddddd;
		}
	</style>
</head>
<body>
	<h1>Questions Dashboard</h1>
	<p><a href="/questions/new">New Question</a></p>
	
	<c:if test="${!empty questions}">
		<table>
			<tr>
			 	<th>Question</th>
			 	<th>Tags</th>
			</tr>
			<c:forEach items="${questions}" var="question">
				<tr>
					<td><a href="/questions/${question.id}">${question.question}</a></td>
					<td>
						<c:forEach items="${question.getTags()}" var="tag" varStatus="loop">
							${tag.subject}<c:if test="${loop.index < question.getTags().size()-1}">, </c:if>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>