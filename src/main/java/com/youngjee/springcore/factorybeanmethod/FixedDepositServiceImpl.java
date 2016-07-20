package com.youngjee.springcore.factorybeanmethod;

import org.apache.log4j.Logger;


public class FixedDepositServiceImpl implements FixedDepositService {
	
	private static Logger logger = Logger.getLogger(FixedDepositServiceImpl.class);
	
	private IFactoryBeanDao fixedDepositDao;

	public FixedDepositServiceImpl() {
		logger.info("FixedDepositServiceImpl initializing");
	}
	
	public void setFixedDepositDao(IFactoryBeanDao fixedDepositDao) {
		logger.info("FixedDepositServiceImpl setFixedDepositDao");
		this.fixedDepositDao = fixedDepositDao;
	}
	
	@Override
	public IFactoryBeanDao getFixedDepositDao() {
		return fixedDepositDao;
	}

	@Override
	public FactoryBeanDTO getFixedDepositDetails(long id) {
		
		return fixedDepositDao.getFixedDepositDetails(id);
		
	}

	@Override
	public boolean createFixedDeposit(FactoryBeanDTO fdd) {
		return fixedDepositDao.createFixedDeposit(fdd);
	}

}
