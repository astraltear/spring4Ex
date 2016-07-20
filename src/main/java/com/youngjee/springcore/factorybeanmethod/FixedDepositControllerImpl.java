package com.youngjee.springcore.factorybeanmethod;

import org.apache.log4j.Logger;


public class FixedDepositControllerImpl implements FixedDepositController {
	
	private static Logger logger = Logger.getLogger(FixedDepositControllerImpl.class);
	private FixedDepositService fixedDepositService;
	
	public FixedDepositControllerImpl() {
		logger.info("FixedDepositControllerImpl INIT..");
	}
	
	public void setFixedDepositService(FixedDepositService fixedDepositService) {
		logger.info("FixedDepositControllerImpl setFixedDepositService..");
		this.fixedDepositService = fixedDepositService;
	}
	

	@Override
	public FixedDepositService getFixedDepositService() {
		return fixedDepositService;
	}

	@Override
	public boolean submit() {
		return fixedDepositService.createFixedDeposit(new FactoryBeanDTO(1, 10000, 365, "someemail@something.com"));
	}

	@Override
	public FactoryBeanDTO get() {
		return fixedDepositService.getFixedDepositDetails(1L);
	}

}
