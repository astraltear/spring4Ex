package com.astraltear.configuration;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

	
	public UserDao(ConnectionMaker connectionMaker) {
		logger.info("UserDao(ConnectionMaker) Constructor!!!");
	}
	
	public void setDataSource(DataSource dataSource) {
		
	}
	

}
