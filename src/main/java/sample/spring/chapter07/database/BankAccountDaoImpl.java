package sample.spring.chapter07.database;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository("bankAccountDao")
public class BankAccountDaoImpl implements BankAccountDao {
	
	private SimpleJdbcInsert insertBankAccountDetail;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.insertBankAccountDetail = new SimpleJdbcInsert(dataSource)
				.withTableName("bank_account_details")
				.usingGeneratedKeyColumns("ACCOUNT_ID");
	}

	@Override
	public int createBankAccount(BankAccountDetails bankAccountDetails) {
		Map<String, Object> parameters = new HashMap<String,Object>(2);
		parameters.put("balance_amount", bankAccountDetails.getBalanceAmount());
		parameters.put("last_transaction_ts", new java.sql.Date(bankAccountDetails.getLastTransactionTimestamp().getTime()));
		Number key = insertBankAccountDetail.executeAndReturnKey(parameters);
		return key.intValue();
				
	}

	@Override
	public void subtractFromAccount(int bankAccountId, int amount) {
		
		int balanceAmount = jdbcTemplate.queryForInt("select balance_amount from bank_account_details where account_id=?", bankAccountId);
		
		if(balanceAmount < amount) {
			throw new RuntimeException("Insufficient balance amount in bank account");
		}
		
		
		jdbcTemplate.update("update bank_account_details set balance_amount=? where account_id =? ", amount,bankAccountId);

	}

}
