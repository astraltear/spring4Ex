package sample.spring.chapter04.lookupmethod;

public interface CustomerRequestService {
	void submitRequest(String requestType, String requestDescription);
	
	public CustomerRequestDetails getCustomerRequestDetails() ;

	public CustomerRequestDao getCustomerRequestDao() ;
}
