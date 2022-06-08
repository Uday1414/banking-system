package com.ty.banking_system.service;

import java.util.List;

import com.ty.banking_system.dao.Accountdao;
import com.ty.banking_system.dto.Account;

public class AccountService {
	Accountdao accountdao = new Accountdao();
	public Account saveAccount(Account account) {
		return accountdao.saveAccount(account);
	}
	public List<Account> getAllAccounts(){

		return accountdao.getAllAccounts();
	}
	
	public Account getAccountById(int id) {
		return accountdao.getAccountById(id);
	}
	
	public Account updateAccountById(int id,Account account) {
		return accountdao.updateAccountById(id,account);
	}
	
	public boolean deleteAccountById(int id) {
		return accountdao.deleteAccountById(id);
	}
}
