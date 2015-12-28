package sample.spring.chapter04.autowiring;

public class CustomerRegistrationServiceImpl_byName implements CustomerRegistrationService {
	
	private CustomerRegistrationDetails customerRegistrationDetails;
	private CustomerRegistrationDao customerRegistrationDao;

	
	public void setCustomerRegistrationDetails(CustomerRegistrationDetails customerRegistrationDetails) {
		this.customerRegistrationDetails = customerRegistrationDetails;
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
