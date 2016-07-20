package com.youngjee.springcore.factorybeanmethod;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;


public class FixedDepositHibernateDao implements IFactoryBeanDao {
	private static Logger logger = Logger.getLogger(FixedDepositHibernateDao.class);
	
	private Map<Long, FactoryBeanDTO> fixedDeposits  = new HashMap<Long, FactoryBeanDTO>();
	
	public FixedDepositHibernateDao() {
		logger.info("FixedDepositHibernateDao initializing");
	}

	@Override
	public FactoryBeanDTO getFixedDepositDetails(long id) {
		return fixedDeposits.get(id);
	}

	@Override
	public boolean createFixedDeposit(FactoryBeanDTO fdd) {
		fixedDeposits.put(fdd.getId(), fdd);
		return true;
	}

}
