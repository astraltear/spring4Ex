package com.astraltear.h2db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<UserVo> {

	@Override
	public UserVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVo userVo = new UserVo();
		userVo.setId(rs.getInt("id"));
		userVo.setName(rs.getString("name"));
		userVo.setEmail(rs.getString("email"));
		return userVo;
	}

}
