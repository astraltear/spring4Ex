package com.astraltear.test;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.astraltear.configuration.UserDao;

/*
 * SingleConnectionDataSource 는 DB 커넥션을 하나만 만들어두고 계속 사용하기 때문에 매우 빠르다. 다중 사용자 환경에서는 사용할 수 없지만 순차적인 테스트에서는 사용하기 좋음
 * 테스트시 xml을 수정해서 운영환경과 개발환경을 접속하는 방법보다는 아래와 같이 Before 메소드에서 직접 DataSource객체를 주입해준다.   
 */

public class SingleConnectionTest {
	
	@Autowired
	UserDao userDao;

	@Before
	public void setUp() throws Exception {
		DataSource dataSource = new SingleConnectionDataSource("jdbc:mysql://localhost:13306/test", "test", "test", true);
		System.out.println(dataSource.getConnection());
		
		userDao.setDataSource(dataSource);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	}

}
