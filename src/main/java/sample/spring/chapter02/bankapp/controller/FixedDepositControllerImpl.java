package sample.spring.chapter02.bankapp.controller;

import org.apache.log4j.Logger;

import sample.spring.chapter02.bankapp.service.FixedDepositService;
import sample.spring.chapter02.domain.FixedDepositDetails;

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
		return fixedDepositService.createFixedDeposit(new FixedDepositDetails(1, 10000, 365, "someemail@something.com"));
	}

	@Override
	public FixedDepositDetails get() {
		return fixedDepositService.getFixedDepositDetails(1L);
	}

}
