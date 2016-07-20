package com.youngjee.springcore.first2;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class First2Main {

	private static Logger logger = Logger.getLogger(First2Main.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springcore.first2.xml");
		logger.debug(context);
		
		First2Controller first2Controller = (First2Controller) context.getBean("controller");
		First2DTO first2dto = new First2DTO(99, 20000, 365, "test@test.com");
		
		logger.info("Submission status of fixed deposit:"+first2Controller.submit(first2dto));
		logger.info("Submission status of fixed deposit info:"+first2Controller.get(Long.parseLong("99")));

	}

}
