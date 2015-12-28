package sample.spring.chapter03.bankapp.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import sample.spring.chapter03.bankapp.domain.BankStatement;
import sample.spring.chapter03.bankapp.domain.FixedDepositDetails;

public class DatabaseOperations {
	private static Map<Long, FixedDepositDetails> fixedDeposits = new  HashMap<Long, FixedDepositDetails>();
	
	public boolean saveFd(FixedDepositDetails fdd) {
		fixedDeposits.put(fdd.getId(), fdd);
		return true;
	}
	
	
	public FixedDepositDetails loadFd(long id) {
		return fixedDeposits.get(id);
	}
	
	public BankStatement getMiniStatement() {
		BankStatement bankStatement = new BankStatement();
		bankStatement.setAmount(100);
		bankStatement.setReferenceNumber("Ref. no. 1");
		bankStatement.setTransactionDate(new Date());
		bankStatement.setTransactionType("credit");
		
		return bankStatement;
		
	}
	
	
}
