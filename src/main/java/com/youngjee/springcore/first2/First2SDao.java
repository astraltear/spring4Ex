package com.youngjee.springcore.first2;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class First2SDao {
	private static Logger logger = Logger.getLogger(First2SDao.class);
	
	private String url;
	private String driverClass;
	private String username;
	private String password;
	
	private Map<Long, First2DTO> fixedDeposits = new HashMap<Long, First2DTO>();
	
	public First2SDao() {
		logger.info(" First2SDao initializing...");
	}
	

	public void setUrl(String url) {
		this.url = url;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public First2DTO getFixedDeposiDetails(long id) {
		return fixedDeposits.get(id);
	}
	
	public boolean createFixedDeposit(First2DTO fdd) {
		fixedDeposits.put(fdd.getId(), fdd);
		return true;
	}
}
