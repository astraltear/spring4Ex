package sample.spring.chapter07.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcExam {
	
	private static Logger logger = LoggerFactory.getLogger(JdbcExam.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext_chapter07_database.xml");
		
	}

}
