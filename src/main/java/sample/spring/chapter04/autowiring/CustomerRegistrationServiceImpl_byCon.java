package sample.spring.chapter04.autowiring;

public class CustomerRegistrationServiceImpl_byCon implements CustomerRegistrationService {
	
	private CustomerRegistrationDetails customerRegistrationDetails;
	private CustomerRegistrationDao customerRegistrationDao;

	public CustomerRegistrationServiceImpl_byCon(CustomerRegistrationDetails customerRegistrationDetails , CustomerRegistrationDao customerRegistrationDao ) {
		this.customerRegistrationDetails = customerRegistrationDetails;
		this.customerRegistrationDao = customerRegistrationDao;
	}
	
	

	@Override
	public void setAccountNumber(String accountNumber) {
		customerRegistrationDetails.setAccountNumber(accountNumber);
	}

	@Override
	public void setAddress(String address) {
		customerRegistrationDetails.setAddress(address);
	}

	@Override
	public void setDebitCardNumber(String cardNumber) {
		customerRegistrationDetails.setCardNumber(cardNumber);
	}

	@Override
	public void register() {
		customerRegistrationDao.registerCustomer(customerRegistrationDetails);
	}

}
