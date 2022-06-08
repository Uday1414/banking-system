package com.ty.banking_system.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.banking_system.dto.AccountHolder;

public class AccountHolderdao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public AccountHolder saveAccountHolder(AccountHolder accountHolder) {
		entityTransaction.begin();
		entityManager.persist(accountHolder);
		entityTransaction.commit();
		return entityManager.find(AccountHolder.class, accountHolder.getId());
	}

	public List<AccountHolder> getAllAccountHolders() {
		String query = "select a from AccountHolder a";
		Query query2 = entityManager.createQuery(query);
		// query2.setParameter(1,"null");
		return query2.getResultList();
	}

	public AccountHolder getAccountHolderById(int id) {
		return entityManager.find(AccountHolder.class, id);
	}

	public AccountHolder updateAccountHolderById(int id, AccountHolder accountHolder) {
		AccountHolder accountHolder2 = entityManager.find(AccountHolder.class, id);
		if (accountHolder.getName() != null) {
			accountHolder2.setName(accountHolder.getName());
		}
		if (accountHolder.getEmail() != null) {
			accountHolder2.setEmail(accountHolder.getEmail());
		}
		if (accountHolder.getPhone() != 0) {
			accountHolder2.setPhone(accountHolder.getPhone());
		}
		if (accountHolder.getPassword() != null) {
			accountHolder2.setPassword(accountHolder.getPassword());
		}
		if (accountHolder.getAdmin() != null) {
			accountHolder2.setAdmin(accountHolder.getAdmin());
		}
		if(accountHolder.getStatus()!=null)
		{
			accountHolder2.setStatus(accountHolder.getStatus());
		}
		entityTransaction.begin();
		entityManager.merge(accountHolder2);
		entityTransaction.commit();
		return accountHolder2;
	}

	public boolean deleteAccountHolderById(int id) {
		AccountHolder accountHolder = entityManager.find(AccountHolder.class, id);
		entityTransaction.begin();
		entityManager.remove(accountHolder);
		entityTransaction.commit();
		if (entityManager.find(AccountHolder.class, id) != null) {
			return false;
		} else {
			return true;
		}
	}

	public List<AccountHolder> validateAccountHolder(String email, String password) {
		String query = "select a from AccountHolder a where a.email=?1 and a.password=?2";
		Query query2 = entityManager.createQuery(query);
		query2.setParameter(1, email);
		query2.setParameter(2, password);
		return query2.getResultList();
	}
	public List<AccountHolder> getAllAccountHoldersByStatus(String status)
	{
		String query = "select a from AccountHolder a where a.status=?1";
		Query query2 = entityManager.createQuery(query);
		query2.setParameter(1,status);
		return query2.getResultList();
	}
	public AccountHolder updateAccountHolderByBalance( double amount,AccountHolder accountHolder) {
		double balance = accountHolder.getBalance()+amount;
		accountHolder.setBalance(balance);		
		entityTransaction.begin();
		entityManager.merge(accountHolder);
		entityTransaction.commit();
		return entityManager.find(AccountHolder.class, accountHolder.getId());
	}
}
