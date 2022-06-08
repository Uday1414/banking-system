package com.ty.banking_system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.banking_system.dto.AccountHolder;
import com.ty.banking_system.service.AccountHolderService;

@WebServlet(value = "/accountholder")
public class ValidateAccountHolder extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
	
		AccountHolderService accountHolderService=new AccountHolderService();
		List<AccountHolder> accountHolders=accountHolderService.validateAccountHolder(email, password);
		if(accountHolders.size()>0)
		{
        AccountHolder accountHolder=accountHolders.get(0);
			if((accountHolder.getAccount()!=null))
			{
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("activeaccountHolder",accountHolder);
			resp.sendRedirect("AccountHolderHomePage.jsp");
			}
			else
			{
				resp.sendRedirect("accountholderlogin.jsp");
			}
		}
		else
		{
			resp.sendRedirect("accountholderlogin.jsp");
		}
	}

}
