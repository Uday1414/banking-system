package com.ty.banking_system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.banking_system.dto.AccountHolder;
import com.ty.banking_system.service.AccountHolderService;

@WebServlet(value = "/deposit")
public class Deposit extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double amount = Double.parseDouble(req.getParameter("amount"));
		HttpSession httpSession = req.getSession();
		AccountHolder accountHolder = (AccountHolder)httpSession.getAttribute("activeaccountHolder");
		AccountHolderService accountHolderService=new AccountHolderService();
		AccountHolder accountHolder2 = accountHolderService.updateAccountHolderByBalance(amount, accountHolder);
		if(accountHolder2!=null) {
			resp.sendRedirect("depositsuccess.jsp");
		}else {
			resp.sendRedirect("depositfailed.jsp");
		}
	}
}
