package sample.spring.chapter02;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.spring.chapter02.bankapp.controller.FixedDepositController;

public class BankApp {
	
	private static Logger logger = Logger.getLogger(BankApp.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext_chapter02.xml");
		FixedDepositController controller = (FixedDepositController) context.getBean("controller");
		
		logger.info("Submission status of fixed deposit : "+ controller.submit());
		logger.info("Returned fixed deposit info : "+ controller.get());
	}

}
