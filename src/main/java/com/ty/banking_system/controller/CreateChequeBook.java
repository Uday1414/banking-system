package com.ty.banking_system.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.banking_system.dto.Account;
import com.ty.banking_system.dto.AccountHolder;
import com.ty.banking_system.dto.RequestAdmin;
import com.ty.banking_system.service.AccountHolderService;
import com.ty.banking_system.service.AccountService;
import com.ty.banking_system.service.RequestAdminService;

@WebServlet(value = "/createcheque")
public class CreateChequeBook extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long chequeBookNo=Long.parseLong(req.getParameter("chequeBookNumber"));
		HttpSession httpSession=req.getSession();
		int id=Integer.parseInt((String)httpSession.getAttribute("AccHolderId"));
		AccountHolderService accountHolderService=new AccountHolderService();
		AccountHolder accountHolder=accountHolderService.getAccountHolderById(id);
		Account account1=accountHolder.getAccount();
		Account account=new Account();
		account.setChequeBookNo(chequeBookNo);
		AccountService accountService=new AccountService();
		Account account2=accountService.updateAccountById(account1.getId(), account);
		if(account2!=null)
		{
			RequestAdminService adminService=new RequestAdminService();
			List<RequestAdmin> admins=adminService.getRequestAdminByAccHolderId(id);
			RequestAdmin admin=admins.get(0);
			adminService.deleteRequestById(admin.getId());
			resp.sendRedirect("receivedchequeBook.jsp");
		}
	}

}
