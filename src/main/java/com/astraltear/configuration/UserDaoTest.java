package com.astraltear.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao userDao1 = (UserDao) context.getBean("userDao");
		UserDao userDao2 = (UserDao) context.getBean("userDao");
		
		System.out.println(userDao1);
		System.out.println(userDao2);
		
		DaoFactory daoFactory = new DaoFactory();
		UserDao dao1 = daoFactory.userDao();
		UserDao dao2 = daoFactory.userDao();
		
		System.out.println(dao1);
		System.out.println(dao2);
		
	}

}
