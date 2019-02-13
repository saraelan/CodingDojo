<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkerboard</title>
<link rel="stylesheet" href="style.css">
</head>
<body>


    <div class="container">
		<% int width = 0, height = 0;
		if(request.getParameter("width") != null){
			width = Integer.parseInt(request.getParameter("width"));	
		}
		if(request.getParameter("height") != null){
			height = Integer.parseInt(request.getParameter("height"));
		} %>
		
		<h1>Checkerboard: <%=width %>W  X  <%=height %>H</h1>
		
		<div class="board">
			<% for(int i = 0; i < height; i++) {
				if(i%2 == 0) { %>
				
					<div class="evenrow">
						<% for(int j = 0; j < width; j++) {
							
							if(j%2 == 0) { %>
							<div class="evencol"></div>
						<% } else { %>
							<div class="oddcol"></div>
						<% } %>	
					<% } %>	
					</div>
					
				<% } else { %>
					<div class="oddrow">
					<% for(int j = 0; j < width; j++) {
						if(j%2 == 0) { %>
						<div class="evencol"></div>
					<% } else { %>
						<div class="oddcol"></div>
					<% } %>	
				<% } %>	
				</div>
			<% } %>
		<% } %>
		</div>	
	
	
	
	
	
	
	
	
	</div>
</body>
</html>