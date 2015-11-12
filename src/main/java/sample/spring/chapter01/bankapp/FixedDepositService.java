package sample.spring.chapter01.bankapp;

import org.apache.log4j.Logger;

public class FixedDepositService {
	private static Logger logger = Logger.getLogger(FixedDepositService.class);
	private FixedDepositDao fixedDepositDao;

	public FixedDepositService() {
		logger.info("FixedDepositService initializing...");
	}
	
	public void setFixedDepositDao(FixedDepositDao fixedDepositDao) {
		logger.info("FixedDepositService setFixedDepositDao...");
		this.fixedDepositDao = fixedDepositDao;
	}

	public FixedDepositDetails getFixedDepositDetails(long id) {
		return fixedDepositDao.getFixedDeposiDetails(id);
	}
	
	public boolean createFixedDeposit(FixedDepositDetails fdd) {
		return fixedDepositDao.createFixedDeposit(fdd);
	}
	
}
