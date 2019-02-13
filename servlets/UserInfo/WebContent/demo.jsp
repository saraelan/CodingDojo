<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  import="java.util.Date"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Demo JSP</title>
</head>
<body>
<h1>Hello world</h1>
<% String firstName = request.getParameter("firstName"); %>
    <!-- displaying the value -->
    <h1><%= firstName %></h1>
    
  <!-- this is a declaration tag for methods -->
    <%! 
    public int add(int a, int b) {
        return a + b;
    }
    %>
    
    <!-- this is a tag for any java code -->
    <% 
    int i = 2;
    int j = 4;
    %>
    <!-- shortcut to output whatever returns from our method call %> -->
    <h3><%= add(i, j) %></h3>
   
    <% for(int index = 0; index < 5; index++) { %>
        <h1><%= index %></h1>
    <% } %>
    <!-- here we have to import the Date class. You will put the import in the first line of the jsp tag. Use the import attribute -->
    <p>The time is: <%= new Date() %></p>
</body>
</html>