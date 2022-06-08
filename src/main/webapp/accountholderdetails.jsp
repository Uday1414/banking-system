<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <%@include file="navbar.jsp" %><br><br>
   <form action="request">
   Name : <input type="text" name="name"> <br> <br>
   Email : <input type="email" name="email"> <br> <br>
   Phone : <input type="number" name="phone"> <br> <br>
   Password : <input type="password" name="password"> <br> <br>
   <input type="submit" name="Submit">
   
   </form>
</body>
</html>