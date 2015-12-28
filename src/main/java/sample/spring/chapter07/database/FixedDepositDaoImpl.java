package sample.spring.chapter07.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository("fixDepositDao")
public class FixedDepositDaoImpl implements FixedDepositDao {
	
	public static Logger logger = LoggerFactory.getLogger(FixedDepositDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
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
		final String sql = "select * from fixed_deposit_details where FIXED_DEPOSIT_ID =:fixedDepositId";
		
		SqlParameterSource namedParameters  = new MapSqlParameterSource("fixedDepositId",fixedDepositId);
		
		return namedParameterJdbcTemplate.queryForObject(sql,namedParameters,
			new RowMapper<FixedDepositDetails>() {
				public FixedDepositDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
					FixedDepositDetails fdd = new FixedDepositDetails();
					fdd.setActive(rs.getString("active"));
					fdd.setBankAccountId(rs.getInt("account_id"));
					fdd.setFdAmount(rs.getInt("amount"));
					fdd.setFdCreationDate(rs.getDate("FD_CREATION_DATE"));
					fdd.setFixedDepositId(rs.getInt("FIXED_DEPOSIT_ID"));
					fdd.setTenure(rs.getInt("TENURE"));
					
					return fdd;
				}
			}
		);
	}

}
