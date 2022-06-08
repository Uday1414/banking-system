package com.ty.banking_system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.banking_system.dto.AccountHolder;
import com.ty.banking_system.service.AccountHolderService;

@WebServlet(value = "/accountrequests")
public class AccountRequests extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AccountHolderService accountHolderService=new AccountHolderService();
		List<AccountHolder> accountHolders=accountHolderService.getAllAccountHoldersByStatus("pending");
		if(accountHolders.size()>0)
		{
			req.setAttribute("accountlist", accountHolders);
			RequestDispatcher dispatcher=req.getRequestDispatcher("request.jsp");
			dispatcher.forward(req, resp);
		}
		else
		{
			resp.sendRedirect("adminhomepage.jsp");
		}
	}

}
