<%@page import="com.mthree.models.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration error</title>
</head>
<body>
      <%
	Customer e = (Customer) request.getAttribute("logedInUser");
%>
     Thanks for the order, <%=e.getCustomerName()%>! <br><br>
     The following items will be delivered to you soon:  <%=e.getBasket()%>! <br><br>
      <a href="/logout"> Log out </a><br><br>
      
</body>
</html>