<%@page import="com.mthree.models.Customer"%>
<%@page import="com.mthree.models.Item"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Greetings</title>
</head>
<body>

<%
	Customer e = (Customer) session.getAttribute("logedInUser");
	ArrayList<Item> l = (ArrayList<Item>) session.getAttribute("itemList");
%>

      Greetings <%=e.getCustomerName()%> <br><br>
      
      Your basket: <%= e.getBasket()%> <br><br>
      
      Available products from store: <%= l%> 
      
      <br><br>
            
   Put a product to your basket by giving it's ID here:<br>
   <form action="/buyItem" method="POST">
  	  <input type="number" name="productID"/>
   <input type="submit" value="buy"/></form><br>
   
   Drop a product out from your basket here:<br>
   <form action="/dropItem" method="POST">
  	  <input type="number" name="productID"/>
   <input type="submit" value="drop"/></form><br>
   
     <br>
    <a href="/checkout"> Checkout </a><br><br>
      
  	<br><br>
  	<a href="/settings"> Setting </a><br>
  	<a href="/logout"> Log out </a><br><br>
</body>
</html>