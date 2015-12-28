package sample.spring.chapter03.bankapp.dao;

import org.apache.log4j.Logger;

import sample.spring.chapter03.bankapp.domain.FixedDepositDetails;
import sample.spring.chapter03.bankapp.utils.DatabaseOperations;

public class FixedDepositDaoImpl implements FixedDepositDao {
	private static Logger logger = Logger.getLogger(FixedDepositDaoImpl.class);
	private DatabaseOperations databaseOperations;
	
	public void setDatabaseOperations(DatabaseOperations databaseOperations) {
		this.databaseOperations = databaseOperations;
	}
	
	public FixedDepositDaoImpl() {
		logger.info(" FixedDepositDaoImplinitializing");
	}

	@Override
	public FixedDepositDetails getFixedDepositDetails(long id) {
		return databaseOperations.loadFd(id);
	}

	@Override
	public boolean createFixedDeposit(FixedDepositDetails fdd) {
		return databaseOperations.saveFd(fdd);
	}

}
