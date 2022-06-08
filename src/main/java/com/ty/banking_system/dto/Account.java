package com.ty.banking_system.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long accNo;
	private String ifscCode;
	private String branch;
	private long chequeBookNo;
	@OneToOne
	@JoinColumn
	private AccountHolder accountHolder;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public long getChequeBookNo() {
		return chequeBookNo;
	}
	public void setChequeBookNo(long chequeBookNo) {
		this.chequeBookNo = chequeBookNo;
	}
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}
	
}
