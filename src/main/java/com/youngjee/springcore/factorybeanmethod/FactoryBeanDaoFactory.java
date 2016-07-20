package com.youngjee.springcore.factorybeanmethod;

import org.apache.log4j.Logger;

public class FactoryBeanDaoFactory {
	private static Logger logger = Logger.getLogger(FactoryBeanDaoFactory.class);
	
	
	public FactoryBeanDaoFactory() {
		logger.info("FixedDepositDaoFactory initializing");
	}

	public IFactoryBeanDao getFixedDepositDao(String daoType) {
		IFactoryBeanDao fixedDepositDao = null;
		
		if("jdbc".equals(daoType)) {
			fixedDepositDao = new FixedDepositJdbcDao();
		} else if("hibernate".equals(daoType)) {
			fixedDepositDao = new FixedDepositHibernateDao();
		}
		
		return fixedDepositDao;
	}
}
