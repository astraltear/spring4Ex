package com.youngjee.springcore.first2;

import org.apache.log4j.Logger;

public class First2Service {
	private static Logger logger = Logger.getLogger(First2Service.class);
	private First2SDao first2Dao;

	public First2Service() {
		logger.info("FixedDepositService initializing...");
	}
	
	public void setFirst2Dao(First2SDao first2Dao) {
		logger.info("FixedDepositService setFirst2Dao...");
		this.first2Dao = first2Dao;
	}

	public First2DTO getFixedDepositDetails(long id) {
		return first2Dao.getFixedDeposiDetails(id);
	}
	
	public boolean createFixedDeposit(First2DTO fdd) {
		return first2Dao.createFixedDeposit(fdd);
	}
}
