package com.youngjee.springcore.first2;

import org.apache.log4j.Logger;

public class First2Controller {

	private static Logger logger = Logger.getLogger(First2Controller.class);
	
	private First2Service first2Service;
	
	public First2Controller() {
		logger.info("First2Controller initializing...");
	}
	
	public void setFirst2Service(First2Service first2Service) {
		logger.info("First2Controller setFixedDepositService...");
		this.first2Service = first2Service;
	}
	
	public boolean submit(First2DTO fdd) {
		return first2Service.createFixedDeposit( fdd );
	}
	
	public First2DTO get(Long id) {
		return first2Service.getFixedDepositDetails(id);
	}
	
}
