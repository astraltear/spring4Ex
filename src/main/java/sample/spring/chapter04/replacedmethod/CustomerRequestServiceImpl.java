package sample.spring.chapter04.replacedmethod;

import org.apache.log4j.Logger;

public class CustomerRequestServiceImpl implements CustomerRequestService {
	
	private static Logger logger = Logger.getLogger(CustomerRequestServiceImpl.class);
	
	private CustomerRequestDao customerRequestDao;
	
	public CustomerRequestServiceImpl( CustomerRequestDao customerRequestDao) {
		logger.info("Created CustomerRequestServiceImpl instance");
		this.customerRequestDao = customerRequestDao;
	}
	
	public Object getMyBean(String beanName) {
		return null;
	}

	@Override
	public void submitRequest(String requestType, String requestDescription) {
		CustomerRequestDetails customerRequestDetails = (CustomerRequestDetails) getMyBean("customerRequestDetails");
	}

}
