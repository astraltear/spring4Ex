package sample.spring.chapter04.autowiring;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiringExam {
	private static Logger logger = Logger.getLogger(AutoWiringExam.class);

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext_chapter04_autowiring.xml");
/*		
		logger.info("Beginning with accessing CustomerRegistrationService (autowire='byType')");
		CustomerRegistrationService customerRegistrationService_1 = (CustomerRegistrationService) context.getBean("customerRegistrationService_byType");
		customerRegistrationService_1.setAccountNumber("account_1");
		customerRegistrationService_1.setAddress("address_1");
		customerRegistrationService_1.setDebitCardNumber("debitCardNumber_1");
		customerRegistrationService_1.register();
		logger.info("Done with accessing CustomerRegistrationService (autowire='byType')");
		*/
		
		
/*
		logger.info("Beginning with accessing CustomerRegistrationService (autowire='Constructor')");
		CustomerRegistrationService customerRegistrationService_2 = (CustomerRegistrationService) context.getBean("customerRegistrationService_byCon");
		customerRegistrationService_2.setAccountNumber("account_1");
		customerRegistrationService_2.setAddress("address_1");
		customerRegistrationService_2.setDebitCardNumber("debitCardNumber_1");
		customerRegistrationService_2.register();
		logger.info("Done with accessing CustomerRegistrationService (autowire='Constructor')");
		*/
		
		logger.info("Beginning with accessing CustomerRegistrationService (autowire='byName')");
		CustomerRegistrationService customerRegistrationService_3 = (CustomerRegistrationService) context.getBean("customerRegistrationService_byName");
		customerRegistrationService_3.setAccountNumber("account_1");
		customerRegistrationService_3.setAddress("address_1");
		customerRegistrationService_3.setDebitCardNumber("debitCardNumber_1");
		customerRegistrationService_3.register();
		logger.info("Done with accessing CustomerRegistrationService (autowire='byName')");
		
	}

}
