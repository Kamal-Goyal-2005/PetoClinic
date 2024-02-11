<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Message Page</title>
</head>
<body>
   
   
   <%String s = (String) request.getAttribute("errormsg");
%>
<%="<h2>The message is "+s+"</h2><br>" %>

   <a href='index.jsp'> Login </a>
</body>
</html>