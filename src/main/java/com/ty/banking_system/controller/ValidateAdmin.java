package com.ty.banking_system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.banking_system.dto.Admin;
import com.ty.banking_system.service.AdminService;

@WebServlet(value = "/admin")
public class ValidateAdmin extends HttpServlet{
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	AdminService adminService=new AdminService();
	List<Admin> admins=adminService.validateAdmin(email, password);
	if(admins.size()>0)
	{
		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("activeadmin",admins);
		resp.sendRedirect("adminhomepage.jsp");
	}
	else
	{
		resp.sendRedirect("adminlogin.jsp");
	}
	
}
}
