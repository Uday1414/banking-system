package com.ty.banking_system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.banking_system.dto.RequestAdmin;
import com.ty.banking_system.service.RequestAdminService;

@WebServlet(value = "/changerequesttoadmin")
public class ShowChangeRequest extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestAdminService adminService=new RequestAdminService();
		List<RequestAdmin> admin=adminService.getAllRequest();
		if(admin.size()>0)
		{
			req.setAttribute("changePhonelist", admin);
			RequestDispatcher dispatcher=req.getRequestDispatcher("requestToShowChangePhone.jsp");
			dispatcher.forward(req, resp);
		}
		else
		{
			resp.sendRedirect("NosuchRequest.jsp");
		}
		
	}

}
