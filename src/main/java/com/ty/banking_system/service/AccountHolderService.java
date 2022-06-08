package com.ty.banking_system.service;

import java.util.List;

import javax.persistence.Query;

import com.ty.banking_system.dao.AccountHolderdao;
import com.ty.banking_system.dto.AccountHolder;

public class AccountHolderService {
	AccountHolderdao accountHolderdao = new AccountHolderdao();
	public AccountHolder saveAccountHolder(AccountHolder accountHolder) {
		return accountHolderdao.saveAccountHolder(accountHolder);
	}
	public List<AccountHolder> getAllAccountHolders(){

		return accountHolderdao.getAllAccountHolders();
	}
	
	public AccountHolder getAccountHolderById(int id) {
		return accountHolderdao.getAccountHolderById(id);
	}
	
	public AccountHolder updateAccountHolderById(int id,AccountHolder accountHolder) {
		return accountHolderdao.updateAccountHolderById(id,accountHolder);
	}
	
	public boolean deleteAccountHolderById(int id) {
		return accountHolderdao.deleteAccountHolderById(id);
	}
	public List<AccountHolder> validateAccountHolder(String email,String password)
	{
		return accountHolderdao.validateAccountHolder(email, password);
	}
	public List<AccountHolder> getAllAccountHoldersByStatus(String status)
	{
		return accountHolderdao.getAllAccountHoldersByStatus(status);
	}
	public AccountHolder updateAccountHolderByBalance( double amount,AccountHolder accountHolder) {
		return accountHolderdao.updateAccountHolderByBalance(amount, accountHolder);
	}
}
