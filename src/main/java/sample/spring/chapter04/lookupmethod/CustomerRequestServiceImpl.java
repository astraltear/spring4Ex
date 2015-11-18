package sample.spring.chapter04.lookupmethod;

import org.apache.log4j.Logger;

public abstract class CustomerRequestServiceImpl implements CustomerRequestService {
	
	private static Logger logger = Logger.getLogger(CustomerRequestServiceImpl.class);
	private CustomerRequestDao customerRequestDao;

	public CustomerRequestServiceImpl(CustomerRequestDao customerRequestDao) {
		logger.info("Created CustomerRequestServiceImpl instance");
		this.customerRequestDao = customerRequestDao;
	}
	
	public abstract CustomerRequestDetails getCustomerRequestDetails();
	
	@Override
	public void submitRequest(String requestType, String requestDescription) {
		// 실제 사용은 아래와 같이하면 여러개의 인스턴스를 만들 수 있다.
		CustomerRequestDetails customerRequestDetails = getCustomerRequestDetails();
		
	}
}
