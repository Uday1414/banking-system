package com.ty.banking_system.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RequestAdmin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long phone;
	private String trace;
	private String checkBook;
	private int accHolderid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getTrace() {
		return trace;
	}
	public void setTrace(String trace) {
		this.trace = trace;
	}
	public String getCheckBook() {
		return checkBook;
	}
	public void setCheckBook(String checkBook) {
		this.checkBook = checkBook;
	}
	public int getAccHolderid() {
		return accHolderid;
	}
	public void setAccHolderid(int accHolderid) {
		this.accHolderid = accHolderid;
	}
	
	
    
	
	

}
