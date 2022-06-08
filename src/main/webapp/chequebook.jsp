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
    <form action="createcheque">
    Cheque Book Number : <input type="number" name="chequeBookNumber">
    <input type="submit" name="Submit">
    </form>
   <% } else{
		response.sendRedirect("adminlogin.jsp");
	} %>

</body>
</html>