package sample.spring.chapter04.dependency;

import org.apache.log4j.Logger;

public class CustomerRequestDetails {
	
	private static Logger logger = Logger.getLogger(CustomerRequestDetails.class);
	
	public CustomerRequestDetails() {
		logger.info("Created CustomerRequestDetails instance");
	}
}
