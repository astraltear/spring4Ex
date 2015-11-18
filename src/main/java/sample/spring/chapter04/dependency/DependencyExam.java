package sample.spring.chapter04.dependency;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * customerRequestService scope=singleton
 * customerRequestDetails scope=prototype
 * customerRequestDao     scope=singleton
 * 
 * 위와 같이 설정할 경우 customerRequestDetails 인스턴스는 싱글턴 인스턴스를 반환한다.
 * 
 * 
 * customerRequestService scope=prototype
 * customerRequestDetails scope=prototype
 * customerRequestDao     scope=singleton
 * 
 * 위와 같이 설정할 경우 customerRequestDetails 인스턴스는 프로토타입 인스턴스를 반환한다.
 *  
 */

public class DependencyExam {
	
	private static Logger logger = Logger.getLogger(DependencyExam.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext_chapter04_dependencies.xml");
		
		logger.info("Beginning with accessing CustomerRequestService");
		
		CustomerRequestService customerRequestService_1 = (CustomerRequestService) context.getBean("customerRequestService");
		CustomerRequestService customerRequestService_2 = context.getBean(CustomerRequestService.class);
		
		logger.info("customerRequestService_1 "+customerRequestService_1);
		logger.info("customerRequestService_2 "+customerRequestService_2);
		
		logger.info("customerRequestService_1.getCustomerRequestDetails "+customerRequestService_1.getCustomerRequestDetails());
		logger.info("customerRequestService_1.getCustomerRequestDetails "+customerRequestService_2.getCustomerRequestDetails());
		
		logger.info("Done with accessing CustomerRequestService");
	}

}
