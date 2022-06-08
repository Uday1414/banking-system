<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%if(session.getAttribute("activeadmin")!=null){ %>
    <%@include file="navbar.jsp" %><br><br>
	<h1 style="background: gray;">Account Created</h1> <br> <br>
	 <a href="adminhomepage.jsp" style="font-size: 30px ; background-color: white;">back to admin home page</a> <br> <br>
	<%}else{
		response.sendRedirect("adminhomepage.jsp");
	} %>
</body>
</html>