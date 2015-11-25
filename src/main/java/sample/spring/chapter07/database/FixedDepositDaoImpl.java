package sample.spring.chapter07.database;

import org.springframework.jdbc.core.JdbcTemplate;

public class FixedDepositDaoImpl implements FixedDepositDao {
	
	private JdbcTemplate jdbcTemplate;

	@Override
	public int createFixedDeposit(FixedDepositDetails fdd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
		// TODO Auto-generated method stub
		return null;
	}

}
