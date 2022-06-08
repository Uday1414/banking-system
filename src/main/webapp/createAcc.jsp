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
   <% session.setAttribute("AccHolderId", request.getParameter("id")); %>>
   <form action="createaccholder">
   Account Number : <input type="number" name="accountNo"> <br> <br>
   IFSC Code : <input type="text" name="ifscCode"> <br> <br>
   Branch : <input type="text" name="branch"> <br> <br>
   Admin Id :<input type="number" name="adminId"> <br> <br>
   <input type="submit" name="Create">
   </form>
   <% } else{
		response.sendRedirect("adminlogin.jsp");
	} %>
</body>
</html>