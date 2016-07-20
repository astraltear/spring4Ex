package com.youngjee.springcore.factorybeanmethod;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanMethodMain {
	
	private static Logger logger = Logger.getLogger(FactoryBeanMethodMain.class);

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springcore.factorybeanmethod.xml");
		FixedDepositController controller = (FixedDepositController) context.getBean("controller");
		
		logger.info("Submission status of fixed deposit : "+ controller.submit());
		logger.info("Returned fixed deposit info : "+ controller.get());
	}

}
