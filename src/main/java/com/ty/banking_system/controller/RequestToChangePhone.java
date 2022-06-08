package com.ty.banking_system.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.banking_system.dto.AccountHolder;
import com.ty.banking_system.dto.RequestAdmin;
import com.ty.banking_system.service.RequestAdminService;

@WebServlet(value = "/requestToChangePhone")
public class RequestToChangePhone extends HttpServlet {
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long phone=Long.parseLong(req.getParameter("phone"));
		HttpSession httpSession=req.getSession();
		AccountHolder accountHolder=(AccountHolder)httpSession.getAttribute("activeaccountHolder");
		//AccountHolder accountHolder = accountHolders.get(0);
		RequestAdmin admin=new  RequestAdmin();
		admin.setAccHolderid(accountHolder.getId());
		admin.setPhone(phone);
		
		RequestAdminService adminService=new RequestAdminService();
		RequestAdmin admin2=adminService.saveRequestAdmin(admin);
		if(admin2!=null)
		{
			resp.sendRedirect("RequestTochangePhoneSuc.jsp");
		}

		}
  
}
