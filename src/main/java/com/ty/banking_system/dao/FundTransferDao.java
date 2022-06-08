package com.ty.banking_system.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.banking_system.dto.AccountHolder;
import com.ty.banking_system.dto.FundTransfer;

public class FundTransferDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public FundTransfer saveFundTransfer(FundTransfer fundTransfer, int id) {
		AccountHolder accountHolder = entityManager.find(AccountHolder.class,id);
		fundTransfer.setAccountHolder(accountHolder);
		entityTransaction.begin();
		entityManager.persist(fundTransfer);
		entityTransaction.commit();
		return fundTransfer;
	}
	
	public List<FundTransfer> getFundTransfersById(int id){
		Query query = entityManager.createQuery("SELECT f FROM FundTransfer f WHERE f.accountHolder.id=?1");
		query.setParameter(1,id);
		return query.getResultList();
	}
	
	public List<FundTransfer> getAllFundTransfers(){
		Query query = entityManager.createQuery("SELECT f FROM FundTransfer f ");
		return query.getResultList();
	}
}
