<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%if(session.getAttribute("activeaccountHolder")!=null){ %>
    <%@include file="navbar.jsp" %><br><br>
    <h1 style="background-color: gray; font-size: 30px">Request Sent Successfully</h1>
    <a href="AccountHolderHomePage.jsp" style="font-size: 30px ; background-color: white;">Back To Home Page</a> <br> <br>
    <%}else{
		response.sendRedirect("accountholderlogin.jsp");
	} %>
      
</body>
</html>