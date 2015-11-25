package sample.spring.chapter07.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("fixedDepositService")
public class FixedDepositServiceImpl implements FixedDepositService {

	@Autowired
	@Qualifier("fixDepositDao")
	private FixedDepositDao myFixDepositDao;
	
	@Override
	public int createFixedDeposit(FixedDepositDetails fdd) throws Exception {
		return myFixDepositDao.createFixedDeposit(fdd);
	}

	@Override
	public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
		// TODO Auto-generated method stub
		return null;
	}

}
