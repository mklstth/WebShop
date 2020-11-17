<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
   Customer Registration Form
      
  <%-- the action is called when the button is pressed ---%>
   <form action="/registerCustomer" method="POST">
   
	   <input type="text" name="customerName"/> UserName<br> 
	   <input type="text" name="password"/> Password<br>
   	<input type="text" name="email"/> Email<br>
   	<input type="text" name="firstName"/> First name<br>
  	  <input type="text" name="familyName"/> Family name <br>
   	
   <%-- the button ---%>
   <input type="submit" value="Register"/>
   
      
   </form>
</body>
</html>