package com.ty.banking_system.service;

import java.util.List;

import com.ty.banking_system.dao.FundTransferDao;
import com.ty.banking_system.dto.FundTransfer;

public class FundTransferService {
	FundTransferDao fundTransferDao = new FundTransferDao();
	public FundTransfer saveFundTransfer(FundTransfer fundTransfer, int id) {
		return fundTransferDao.saveFundTransfer(fundTransfer, id);
	}
	
	public List<FundTransfer> getFundTransfersById(int id){
		return fundTransferDao.getFundTransfersById(id);
	}
	
	public List<FundTransfer> getAllFundTransfers(){
		return fundTransferDao.getAllFundTransfers();
	}
}
