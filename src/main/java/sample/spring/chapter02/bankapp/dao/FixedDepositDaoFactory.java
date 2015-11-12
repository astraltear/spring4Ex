package sample.spring.chapter02.bankapp.dao;

import org.apache.log4j.Logger;

public class FixedDepositDaoFactory {
	private static Logger logger = Logger.getLogger(FixedDepositDaoFactory.class);
	
	
	public FixedDepositDaoFactory() {
		logger.info("FixedDepositDaoFactory initializing");
	}

	public static FixedDepositDao getFixedDepositDao(String daoType) {
		FixedDepositDao fixedDepositDao = null;
		
		if("jdbc".equals(daoType)) {
			fixedDepositDao = new FixedDepositJdbcDao();
		} else if("hibernate".equals(daoType)) {
			fixedDepositDao = new FixedDepositHibernateDao();
		}
		
		return fixedDepositDao;
	}

}
