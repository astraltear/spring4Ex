package sample.spring.chapter01.bankapp;

import org.apache.log4j.Logger;

public class FixedDepositController {
	private static Logger logger = Logger.getLogger(FixedDepositController.class);
	
	private FixedDepositService fixedDepositService;
	
	public FixedDepositController() {
		logger.info("FixedDepositController initializing...");
	}
	
	public void setFixedDepositService(FixedDepositService fixedDepositService) {
		logger.info("FixedDepositController setFixedDepositService...");
		this.fixedDepositService = fixedDepositService;
	}
	
	public boolean submit(FixedDepositDetails fdd) {
		return fixedDepositService.createFixedDeposit( fdd );
	}
	
	public FixedDepositDetails get(Long id) {
		return fixedDepositService.getFixedDepositDetails(id);
	}

}
