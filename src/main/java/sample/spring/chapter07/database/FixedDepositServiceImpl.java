package sample.spring.chapter07.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Service("fixedDepositService")
public class FixedDepositServiceImpl implements FixedDepositService {
	
	Logger logger = LoggerFactory.getLogger(FixedDepositServiceImpl.class);

	@Autowired
	private TransactionTemplate transactionTemplate;
	
	
	@Autowired
	@Qualifier("fixDepositDao")
	private FixedDepositDao myFixDepositDao;
	
	@Autowired
	private BankAccountDao bankAccountDao;
	
	@Override
	public int createFixedDeposit(FixedDepositDetails fdd) throws Exception {
		
		transactionTemplate.execute(new TransactionCallback<FixedDepositDetails>() {

			@Override
			public FixedDepositDetails doInTransaction(TransactionStatus status) {
				try {
					int returnFixedDepositId = myFixDepositDao.createFixedDeposit(fdd);
					fdd.setFixedDepositId(returnFixedDepositId);
					
					bankAccountDao.subtractFromAccount(fdd.getBankAccountId(), fdd.getFdAmount());
					
					
				} catch (Exception e) {
					status.setRollbackOnly();
				}
				return fdd;
			}
		});
		return fdd.getFixedDepositId();
	}

	@Override
	public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
		return myFixDepositDao.getFixedDeposit(fixedDepositId);
	}

}
