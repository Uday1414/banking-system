package com.ty.banking_system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.banking_system.dto.Account;
import com.ty.banking_system.dto.AccountHolder;
import com.ty.banking_system.dto.Admin;
import com.ty.banking_system.service.AccountHolderService;
import com.ty.banking_system.service.AccountService;
import com.ty.banking_system.service.AdminService;

@WebServlet(value = "/createaccholder")
public class CreateAccountByAdmin extends HttpServlet{
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	long accNo=Long.parseLong(req.getParameter("accountNo"));
	String ifscCode=req.getParameter("ifscCode");
	String branch=req.getParameter("branch");
	HttpSession httpSession=req.getSession();
	int id=Integer.parseInt((String)httpSession.getAttribute("AccHolderId"));
	int adminId=Integer.parseInt(req.getParameter("adminId"));
	
	AccountHolderService accountHolderService=new AccountHolderService();
	AccountHolder accountHolder1=accountHolderService.getAccountHolderById(id);
	
	Account account=new Account();
	account.setAccNo(accNo);
	account.setIfscCode(ifscCode);
	account.setBranch(branch);
	account.setAccountHolder(accountHolder1); 
	
	AccountService accountService=new AccountService();
	Account account2=accountService.saveAccount(account);
	if(account2!=null)
	{
		AdminService adminService=new AdminService();
		Admin admin=adminService.getAdminById(adminId);
		AccountHolder accountHolder=new AccountHolder();
		accountHolder.setAdmin(admin);
		accountHolder.setStatus("Created");
		accountHolderService.updateAccountHolderById(id, accountHolder);
		resp.sendRedirect("AccountCreated.jsp");
	}
	else
	{
		resp.sendRedirect("adminhomepage.jsp");
	}
	
   }
}
