package sample.spring.chapter04.replacedmethod;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * use lookup method 사용하기 
 * 
 * customerRequestService scope=singleton
 * customerRequestDetails scope=prototype
 * customerRequestDao     scope=singleton
 * 
 * 위와 같이 설정할 경우 lookup method를 사용하면  customerRequestDetails 인스턴스는 프로토타입 인스턴스로 반환한다.
 *  
 */

public class ReplacedMethodExam {
	
	private static Logger logger = Logger.getLogger(ReplacedMethodExam.class);
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext_chapter04_replacedmethod.xml");
		
		logger.info("Beginning with accessing CustomerRequestService");
		
		CustomerRequestService customerRequestService_1 = (CustomerRequestService) context.getBean("customerRequestService");
		CustomerRequestService customerRequestService_2 = context.getBean(CustomerRequestService.class);
		
		logger.info("customerRequestService_1 "+customerRequestService_1);
		logger.info("customerRequestService_2 "+customerRequestService_2);
		
		
		logger.info("Done with accessing CustomerRequestService");
	}

}
