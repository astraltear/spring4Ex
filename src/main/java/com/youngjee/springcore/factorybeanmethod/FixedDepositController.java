package com.youngjee.springcore.factorybeanmethod;


public interface FixedDepositController {
	FixedDepositService getFixedDepositService();
	boolean submit();
	FactoryBeanDTO get();
}
