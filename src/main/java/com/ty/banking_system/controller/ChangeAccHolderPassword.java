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

import com.ty.banking_system.dto.AccountHolder;
import com.ty.banking_system.dto.Admin;
import com.ty.banking_system.service.AccountHolderService;

@WebServlet(value = "/changePassword")
public class ChangeAccHolderPassword extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password = req.getParameter("password");

		HttpSession httpSession = req.getSession();
		AccountHolder accountHolder = (AccountHolder) httpSession.getAttribute("activeaccountHolder");
		//AccountHolder accountHolder = accountHolders.get(0);
		if (accountHolder != null) {

			accountHolder.setPassword(password);
			int id = accountHolder.getId();
			// Integer.parseInt((String)httpSession.getAttribute("id"));

			AccountHolderService accountHolderService = new AccountHolderService();
			// AccountHolder accountHolder = accountHolderService.getAccountHolderById(id);
			AccountHolder accountHolder2 = accountHolderService.updateAccountHolderById(id, accountHolder);
			resp.sendRedirect("passwordupdated.jsp");
		} else {
			resp.sendRedirect("accountholderdetails.jsp");
		}
	}
}
