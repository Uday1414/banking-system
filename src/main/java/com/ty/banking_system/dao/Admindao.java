package com.ty.banking_system.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.banking_system.dto.Admin;

public class Admindao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	public Admin registerAdmin(Admin admin)
	{
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		return entityManager.find(Admin.class, admin.getId());
	}
	public List<Admin> validateAdmin(String email,String password)
	{
		String query="select a from Admin a where a.email=?1 and a.password=?2";
		Query query2=entityManager.createQuery(query);
		query2.setParameter(1, email);
		query2.setParameter(2, password);
		return query2.getResultList();
	}
	public Admin getAdminById(int id) {
		return entityManager.find(Admin.class, id);
	}
	
	public Admin updateAdminById(int id,Admin admin) {
		Admin admin2 = entityManager.find(Admin.class, id);
		if(admin.getEmail()!=null) {
			admin2.setEmail(admin.getEmail());
		}
		if(admin.getName()!=null) {
			admin2.setName(admin.getName());
		}
		if(admin.getPhone()!=0) {
			admin2.setPhone(admin.getPhone());
		}
		if(admin.getPassword()!=null) {
			admin2.setPassword(admin.getPassword());
		}
		entityTransaction.begin();
		entityManager.merge(admin2);
		entityTransaction.commit();
		return admin2;
	}
	
	public boolean deleteAdminById(int id) {
		Admin admin = entityManager.find(Admin.class, id);
		entityTransaction.begin();
		entityManager.remove(admin);
		entityTransaction.commit();
		if (entityManager.find(Admin.class, id) != null) {
			return false;
		} else {
			return true;
		}
	}

}