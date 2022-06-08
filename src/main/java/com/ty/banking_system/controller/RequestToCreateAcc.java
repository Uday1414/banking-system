package com.ty.banking_system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.banking_system.dto.AccountHolder;
import com.ty.banking_system.service.AccountHolderService;

@WebServlet(value = "/request")
public class RequestToCreateAcc extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		String name=req.getParameter("name");
		String email=req.getParameter("email");
	    long phone=Long.parseLong(req.getParameter("phone"));
	    String password=req.getParameter("password");
	    
	    AccountHolder accountHolder=new AccountHolder();
	    accountHolder.setName(name);
	    accountHolder.setEmail(email);
	    accountHolder.setPhone(phone);
	    accountHolder.setPassword(password);
	    accountHolder.setStatus("pending");
	    AccountHolderService accountHolderService=new AccountHolderService();
	    AccountHolder accountHolder2=accountHolderService.saveAccountHolder(accountHolder);
	    if(accountHolder2!=null)
	    {
	    	resp.sendRedirect("requestSent.jsp");
	    }
	    else
	    {
	    	
	    }
	}

}
