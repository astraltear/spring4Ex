package com.astraltear.h2db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.astraltear.h2db.config.H2DataSource;
import com.astraltear.h2db.config.SpringRootConfig;



public class JdbcTemplateMain {

	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.astraltear.h2db.config");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(H2DataSource.class,SpringRootConfig.class);
		
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("getJdbcTemplate"); 
		
		String sql ="select * from users where id=?";
		
		UserVo userVo =  jdbcTemplate.queryForObject(sql,new Object[] {1}, new UserMapper());
		System.out.println(userVo);
		
		sql ="select * from users";
		
		List<UserVo> list = (List) jdbcTemplate.query(sql, new UserMapper2());
		
		for (UserVo userVo2 : list) {
			System.out.println(userVo2);
		}
		
	}
	
	private static final class UserMapper2 implements RowMapper<UserVo>{

		@Override
		public UserVo mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVo userVo = new UserVo();
			userVo.setId(rs.getInt("id"));
			userVo.setName(rs.getString("name"));
			userVo.setEmail(rs.getString("email"));
			return userVo;
		}
		
	}
	

}
