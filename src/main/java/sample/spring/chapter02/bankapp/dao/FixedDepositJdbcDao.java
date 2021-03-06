package sample.spring.chapter02.bankapp.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import sample.spring.chapter02.domain.FixedDepositDetails;

public class FixedDepositJdbcDao implements FixedDepositDao {
	private static Logger logger = Logger.getLogger(FixedDepositJdbcDao.class);
	
	private Map<Long, FixedDepositDetails> fixedDeposits  = new HashMap<Long, FixedDepositDetails>();
	
	public FixedDepositJdbcDao() {
		logger.info("FixedDepositJdbcDao initializing");
	}

	@Override
	public FixedDepositDetails getFixedDepositDetails(long id) {
		return fixedDeposits.get(id);
	}

	@Override
	public boolean createFixedDeposit(FixedDepositDetails fdd) {
		fixedDeposits.put(fdd.getId(), fdd);
		return true;
	}

}
