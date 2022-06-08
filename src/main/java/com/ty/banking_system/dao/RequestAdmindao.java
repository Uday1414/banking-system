package com.ty.banking_system.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.banking_system.dto.RequestAdmin;

public class RequestAdmindao {
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public RequestAdmin saveRequestAdmin(RequestAdmin admin)
	{
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		return admin;
	}
	public RequestAdmin getRequestAdminById(int id)
	{
		return entityManager.find(RequestAdmin.class, id);
	}
	
	public List<RequestAdmin> getAllRequest()
	{
		String query = "select a from RequestAdmin a";
		Query query2 = entityManager.createQuery(query);
		return query2.getResultList();
	}
	public boolean deleteRequestById(int id)
	{
		
		entityTransaction.begin();
		entityManager.remove(entityManager.find(RequestAdmin.class,id));
		entityTransaction.commit();
		return true;
	}
	public List<RequestAdmin> getRequestAdminByAccHolderId(int id)
	{
		String query = "select a from RequestAdmin a where a.accHolderid=?1";
		Query query2 = entityManager.createQuery(query);
		query2.setParameter(1, id);
		return query2.getResultList();
	}

}
