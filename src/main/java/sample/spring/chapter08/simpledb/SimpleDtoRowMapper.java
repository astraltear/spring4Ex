package sample.spring.chapter08.simpledb;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SimpleDtoRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		SimpleDTO dto = new SimpleDTO();
		dto.setName(rs.getString("name"));
		dto.setSex(rs.getString("sex"));
		dto.setAge(rs.getInt("age"));
		dto.setRegDate(rs.getDate("regDate"));
		return dto;
	}

}
