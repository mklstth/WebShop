<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>eCommerse Index</title>
</head>
<body>

eCommerse Application Main Page<br><br>

 <a href="/regForm"> Go To Register </a> <br><br>
 
 <form action="/login" method="POST">
   
	   UserName <input type="text" name="customerName"/> <br>
	   
	    Password <input type="password" name="password"/> <br>
   
   <%-- the button ---%>
   <input type="submit" value="login"/>
   </form>
</body>
</html>