package sample.spring.chapter01.bankapp;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankApp {
	private static Logger logger = Logger.getLogger(BankApp.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		logger.debug(context);
		
		FixedDepositController controller = (FixedDepositController) context.getBean("controller");
		
		FixedDepositDetails fdd = new FixedDepositDetails(99, 20000, 365, "test@test.com");
		
		logger.info("Submission status of fixed deposit:"+controller.submit(fdd));
		logger.info("Submission status of fixed deposit info:"+controller.get(Long.parseLong("99")));
		
	}

}
