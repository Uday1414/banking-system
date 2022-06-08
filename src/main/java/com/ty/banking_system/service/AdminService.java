package com.ty.banking_system.service;

import java.util.List;

import com.ty.banking_system.dao.Admindao;
import com.ty.banking_system.dto.Admin;

public class AdminService {
    Admindao admindao=new Admindao();
	public Admin registerAdmin(Admin admin)
	{
	  return admindao.registerAdmin(admin);
	}
	public List<Admin> validateAdmin(String email,String password)
	{
	 return admindao.validateAdmin(email, password);
	}
	
	public Admin getAdminById(int id) {
		return admindao.getAdminById(id);
	}
	
	public Admin updateAdminById(int id,Admin admin) {
		return admindao.updateAdminById(id,admin);
	}
	
	public boolean deleteAdminById(int id) {
		return admindao.deleteAdminById(id);
	}
}
