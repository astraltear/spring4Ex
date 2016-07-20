package com.youngjee.springcore.factorybeanmethod;


public interface FixedDepositService {
	IFactoryBeanDao getFixedDepositDao();
	
	FactoryBeanDTO getFixedDepositDetails(long id);

	boolean createFixedDeposit(FactoryBeanDTO fdd);
}
