<%@ page import="com.mthree.models.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
   Customer Update Page<br>
   
   
<%
	Customer e = (Customer) request.getAttribute("logedInUser");	
%>
   
  <%-- the action is called when the button is pressed ---%>
   <form action="/updateCustomer" method="POST">
   
	<input type="text" name="customerName" value=<%= e.getCustomerName() %>> UserName<br> 
	<input type="text" name="password" value=<%= e.getPassword() %>> Password<br>
   	<input type="text" name="email" value=<%= e.getEmail() %>> Email<br>
   	<input type="text" name="firstName" value=<%= e.getFirstName() %>> First name<br>
  	<input type="text" name="familyName" value=<%= e.getFamilyName() %>> Family name <br>
   	
   <input type="submit" value="Update"/>
   
      
   </form>
</body>
</html>