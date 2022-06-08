package com.ty.banking_system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.banking_system.dto.AccountHolder;
import com.ty.banking_system.dto.FundTransfer;
import com.ty.banking_system.service.FundTransferService;

@WebServlet(value = "/fundtransfer")
public class FundTransferr extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bankName = req.getParameter("bank");
		String ifsc = req.getParameter("ifsc");
		String accNumber = req.getParameter("accnumber");
		double amount = Double.parseDouble(req.getParameter("amount"));
		FundTransfer fundTransfer = new FundTransfer();
		fundTransfer.setAccNumber(accNumber);
		fundTransfer.setAmount(amount);
		fundTransfer.setBankName(bankName);
		fundTransfer.setIfscCode(ifsc);
		HttpSession httpSession = req.getSession();
		AccountHolder accountHolder = (AccountHolder) httpSession.getAttribute("activeaccountHolder");
		if ( accountHolder.getBalance()>= amount) {
			FundTransferService fundTransferService = new FundTransferService();
			double balance=accountHolder.getBalance()-amount;
			accountHolder.setBalance(balance);
			FundTransfer fundTransfer2 = fundTransferService.saveFundTransfer(fundTransfer, accountHolder.getId());
			if (fundTransfer2 != null) {
				resp.sendRedirect("fundtransfersucces.jsp");
			} else {
				resp.sendRedirect("fundtransferfailed.jsp");
			}
		} else {
			resp.sendRedirect("fundtransferfailed.jsp");
		}
	}
}
