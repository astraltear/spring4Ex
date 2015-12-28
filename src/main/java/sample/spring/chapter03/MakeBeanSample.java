package sample.spring.chapter03;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.spring.chapter03.beans.BankDetails;

public class MakeBeanSample {
	private static Logger logger = Logger.getLogger(MakeBeanSample.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext_chapter03_schema.xml");
		BankDetails bankDetails = (BankDetails) context.getBean("bankDetails");
		
		logger.info(bankDetails);
		
			
		
	}

}
