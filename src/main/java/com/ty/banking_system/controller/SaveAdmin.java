package com.ty.banking_system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.banking_system.dto.Admin;
import com.ty.banking_system.service.AdminService;

@WebServlet(value = "/saveadmin")
public class SaveAdmin extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name=req.getParameter("name");
       String email=req.getParameter("email");
       long phone=Long.parseLong(req.getParameter("phone"));
       String password=req.getParameter("password");
       
       Admin admin=new Admin();
       admin.setName(name);
       admin.setEmail(email);
       admin.setPassword(password);
       admin.setPhone(phone);
       
       AdminService adminService=new AdminService();
       Admin admin2=adminService.registerAdmin(admin);
       if(admin2!=null)
       {
    	   resp.sendRedirect("adminlogin.jsp");
       }
       else
       {
    	   resp.sendRedirect("registeradmin.jsp");
       }
	}
}
