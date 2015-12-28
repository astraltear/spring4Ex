package sample.spring.chapter04.dependency;

import org.apache.log4j.Logger;

public class CustomerRequestServiceImpl implements CustomerRequestService {
	
	private static Logger logger = Logger.getLogger(CustomerRequestServiceImpl.class);
	private CustomerRequestDetails customerRequestDetails;
	private CustomerRequestDao customerRequestDao;

	public CustomerRequestServiceImpl(CustomerRequestDetails customerRequestDetails,CustomerRequestDao customerRequestDao) {
		logger.info("Created CustomerRequestServiceImpl instance");
		this.customerRequestDetails = customerRequestDetails;
		this.customerRequestDao = customerRequestDao;
	}
	
	@Override
	public void submitRequest(String requestType, String requestDescription) {

	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		CustomerRequestServiceImpl.logger = logger;
	}

	public CustomerRequestDetails getCustomerRequestDetails() {
		return customerRequestDetails;
	}

	public CustomerRequestDao getCustomerRequestDao() {
		return customerRequestDao;
	}

}
