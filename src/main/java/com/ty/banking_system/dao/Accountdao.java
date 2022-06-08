package com.ty.banking_system.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.banking_system.dto.Account;

public class Accountdao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Account saveAccount(Account account) {
		entityTransaction.begin();
		entityManager.persist(account);
		entityTransaction.commit();
		return entityManager.find(Account.class, account.getId());
	}

	public List<Account> getAllAccounts() {
		String query = "select a from Account a";
		Query query2 = entityManager.createQuery(query);
		return query2.getResultList();
	}

	public Account getAccountById(int id) {
		return entityManager.find(Account.class, id);
	}

	public Account updateAccountById(int id, Account account) {
		Account account2 = entityManager.find(Account.class, id);
		if (account.getAccNo() != 0) {
			account2.setAccNo(account.getAccNo());
		}
		if (account.getIfscCode() != null) {
			account2.setIfscCode(account.getIfscCode());
		}
		if (account.getBranch() != null) {
			account2.setBranch(account.getBranch());
		}
		if(account.getChequeBookNo()!=0)
		{
			account2.setChequeBookNo(account.getChequeBookNo());
		}
		entityTransaction.begin();
		entityManager.merge(account2);
		entityTransaction.commit();
		return account2;
	}

	public boolean deleteAccountById(int id) {
		Account account = entityManager.find(Account.class, id);
		entityTransaction.begin();
		entityManager.remove(account);
		entityTransaction.commit();
		if (entityManager.find(Account.class, id) != null) {
			return false;
		} else {
			return true;
		}

	}
}
