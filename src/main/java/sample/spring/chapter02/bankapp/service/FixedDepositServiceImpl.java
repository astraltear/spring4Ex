package sample.spring.chapter02.bankapp.service;

import org.apache.log4j.Logger;

import sample.spring.chapter02.bankapp.dao.FixedDepositDao;
import sample.spring.chapter02.domain.FixedDepositDetails;

public class FixedDepositServiceImpl implements FixedDepositService {
	
	private static Logger logger = Logger.getLogger(FixedDepositServiceImpl.class);
	
	private FixedDepositDao fixedDepositDao;

	public FixedDepositServiceImpl() {
		logger.info("FixedDepositServiceImpl initializing");
	}
	
	public void setFixedDepositDao(FixedDepositDao fixedDepositDao) {
		logger.info("FixedDepositServiceImpl setFixedDepositDao");
		this.fixedDepositDao = fixedDepositDao;
	}
	
	@Override
	public FixedDepositDao getFixedDepositDao() {
		return fixedDepositDao;
	}

	@Override
	public FixedDepositDetails getFixedDepositDetails(long id) {
		
		return fixedDepositDao.getFixedDepositDetails(id);
		
	}

	@Override
	public boolean createFixedDeposit(FixedDepositDetails fdd) {
		return fixedDepositDao.createFixedDeposit(fdd);
	}

}
