package sample.spring.chapter07.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository("fixDepositDao")
public class FixedDepositDaoImpl implements FixedDepositDao {
	
	public static Logger logger = LoggerFactory.getLogger(FixedDepositDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public FixedDepositDaoImpl() {
		logger.info("FixedDepositDaoImpl Create !!!");
	}

	@Override
	public int createFixedDeposit(FixedDepositDetails fdd) {
		final String sql = "insert into fixed_deposit_details 	(ACCOUNT_ID,FD_CREATION_DATE,AMOUNT,TENURE,ACTIVE) values(?,?,?,?,?)";
		
		KeyHolder keyHolder =new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, new String[] {"FIXED_DEPOSIT_ID"});
				ps.setInt(1, fdd.getBankAccountId());
				ps.setDate(2, new Date(fdd.getFdCreationDate().getTime()));
				ps.setInt(3, fdd.getFdAmount());
				ps.setInt(4, fdd.getTenure());
				ps.setString(5, fdd.getActive());
				return ps;
				
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public FixedDepositDetails getFixedDeposit(int fixedDepositId) {
		// TODO Auto-generated method stub
		return null;
	}

}
