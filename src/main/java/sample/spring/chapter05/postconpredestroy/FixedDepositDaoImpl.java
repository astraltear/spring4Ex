package sample.spring.chapter05.postconpredestroy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;

public class FixedDepositDaoImpl implements FixedDepositDao {
	
	private static Logger logger = Logger.getLogger(FixedDepositDaoImpl.class);
	private DatabaseConnection connection;

	public FixedDepositDaoImpl() {
		logger.info("FixedDepositDaoImpl constructor invoked");
	}

	@PostConstruct
	public void initializeDbConnection() {
		logger.info("FixedDepositDaoImpl createFixedDeposit initializeDbConnection >>>>>");
		connection = DatabaseConnection.getInstance();
	}
	
	
	@PreDestroy
	public void releaseDbConnection() {
		logger.info("FixedDepositDaoImpl createFixedDeposit releaseDbConnection <<<<<");
		connection.releaseConnection();
	}
	
	
	@Override
	public boolean createFixedDeposit(FixedDepositDetails fdd) {
		logger.info("FixedDepositDaoImpl createFixedDeposit method invoked");
		return true;
	}
	
	

}
