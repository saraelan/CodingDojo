<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Top Ten Songs !!</title>
</head>
<body>
<h3><a href="/dashboard">Dashboard</a></h3>
	<h1>Top Ten Songs: </h1>
	
	<div>
		<c:forEach var="song" items="${songs}">
			<h2>${song.rating } - <a href="/songs/${song.id }">${song.title }</a> - ${song.artist }</h2>
		</c:forEach>
	</div>
</body>
</html>