<%@page import="com.mthree.models.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%

	Customer e = (Customer) request.getAttribute("emp");

%>



Customer details are : <br>

<%=e%>



</body>
</html>