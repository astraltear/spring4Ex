package sample.spring.chapter04.dependency;

public interface CustomerRequestService {
	void submitRequest(String requestType, String requestDescription);
	
	public CustomerRequestDetails getCustomerRequestDetails() ;

	public CustomerRequestDao getCustomerRequestDao() ;
}
