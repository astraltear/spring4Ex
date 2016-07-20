package com.youngjee.springcore.factorybeanmethod;

public interface IFactoryBeanDao {


	FactoryBeanDTO getFixedDepositDetails(long id);

	boolean createFixedDeposit(FactoryBeanDTO fdd);
	
}
