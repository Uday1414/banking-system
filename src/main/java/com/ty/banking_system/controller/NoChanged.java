package com.ty.banking_system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.banking_system.dto.AccountHolder;
import com.ty.banking_system.dto.RequestAdmin;
import com.ty.banking_system.service.AccountHolderService;
import com.ty.banking_system.service.RequestAdminService;

@WebServlet(value = "/noChanged")
public class NoChanged extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		RequestAdminService adminService=new RequestAdminService();
		RequestAdmin admin=adminService.getRequestById(id);
		
		AccountHolderService accountHolderService=new AccountHolderService();
		AccountHolder accountHolder=new AccountHolder();
		accountHolder.setPhone(admin.getPhone());
		AccountHolder accountHolder2=accountHolderService.updateAccountHolderById(admin.getAccHolderid(), accountHolder);
		if(accountHolder2!=null)
		{
			adminService.deleteRequestById(id);
			resp.sendRedirect("nochanged.jsp");
		}
	}

}
