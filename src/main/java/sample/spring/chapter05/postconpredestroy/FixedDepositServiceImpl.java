package sample.spring.chapter05.postconpredestroy;

import org.apache.log4j.Logger;

public class FixedDepositServiceImpl implements FixedDepositService {

	private static Logger logger = Logger.getLogger(FixedDepositServiceImpl.class);
	private FixedDepositDao myFixedDepositDao;
	
	public void setMyFixedDepositDao(FixedDepositDao myFixedDepositDao) {
//		logger.info("FixedDepositServiceImpl's setMyFixedDepositDao method invoked");
		this.myFixedDepositDao = myFixedDepositDao;
	}
	
	@Override
	public void createFixedDeposit(FixedDepositDetails fdd) throws Exception {
		myFixedDepositDao.createFixedDeposit(fdd);

	}

}
