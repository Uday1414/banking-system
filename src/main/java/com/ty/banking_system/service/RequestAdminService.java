package com.ty.banking_system.service;

import java.util.List;

import com.ty.banking_system.dao.RequestAdmindao;
import com.ty.banking_system.dto.RequestAdmin;

public class RequestAdminService {
	RequestAdmindao requestAdmindao=new RequestAdmindao(); 
	
	public List<RequestAdmin> getAllRequest()
	{
	return requestAdmindao.getAllRequest();
	}
	public boolean deleteRequestById(int id)
	{
	return requestAdmindao.deleteRequestById(id);
	}
	public RequestAdmin saveRequestAdmin(RequestAdmin admin)
	{
		return requestAdmindao.saveRequestAdmin(admin);
	}
	public RequestAdmin getRequestById(int id)
	{
		return requestAdmindao.getRequestAdminById(id);
	}
	public List<RequestAdmin> getRequestAdminByAccHolderId(int id)
	{
		return requestAdmindao.getRequestAdminByAccHolderId(id);
	}

}
