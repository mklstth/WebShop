<%@page import="com.mthree.models.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Settings</title>
</head>
<body>
Your profile data: <br>
<%
	Customer e = (Customer) request.getAttribute("logedInUser");
%>
      UserName    = <%=e.getCustomerName()%> <br>
      Email       =  <%=e.getEmail()%> <br>   
      First name  =  <%=e.getFirstName()%> <br>   
      Family name =  <%=e.getFamilyName()%> <br>   
      Password    =  <%=e.getPassword()%> <br>   
      
    <a href="/change"> Change </a><br>
  	<a href="/greetings"> Back </a>
   
</body>
</html>