<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: silver;">
  <%@include file="navbar.jsp" %><br><br>
  <h1 style="background-color: gray;">Login To Access As Account Holder</h1>
    <form action="accountholder">
    Email : <input type="email" name="email"> <br> <br>
    Password : <input type="text" name="password"> <br> <br>
    <input type="submit" name="login"> <br> <br> <br>
    <a href="accountholderdetails.jsp" style="font-size: 20px ; background-color: gray;">Create New AccountHolder</a>
    </form>
</body>
</html>