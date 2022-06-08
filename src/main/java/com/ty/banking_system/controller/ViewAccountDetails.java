package com.ty.banking_system.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.banking_system.dto.AccountHolder;
import com.ty.banking_system.service.AccountHolderService;

@WebServlet(value = "/viewaccountholderdetails")
public class ViewAccountDetails extends HttpServlet{
	@Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   AccountHolderService accountHolderService=new AccountHolderService();
   AccountHolder accountHolder=accountHolderService.getAccountHolderById(0);
   
   if(accountHolder!=null)
   {
	   req.setAttribute("accountlist", accountHolder);
		RequestDispatcher dispatcher=req.getRequestDispatcher("request.jsp");
		dispatcher.forward(req, resp);
   }
   else
   {
	   
   }
 }
}
