<%@page import="java.util.ArrayList"%>
<%@page import="com.ty.banking_system.dto.AccountHolder"%>
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
	<h1 style="background-color: gray">REQUEST LIST</h1>
	<table border="3px" cellpadding=20px>
		<tr>
			<th>Id</th>

			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>CREATE</th>
		</tr>
		<%
		ArrayList<AccountHolder> accountholders=(ArrayList) request.getAttribute("accountlist");
		for(AccountHolder accountHolder:accountholders){
		%>

		<tr>
			<td><%=accountHolder.getId()%></td>
			<td><%=accountHolder.getName()%></td>
			<td><%=accountHolder.getEmail()%></td>
			<td><%=accountHolder.getPhone()%></td>
			<td><a href="createAcc.jsp?id=<%=accountHolder.getId()%>">create</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<% } else{
		response.sendRedirect("adminlogin.jsp");
	} %>	
</body>
</html>