package sample.spring.chapter04.autowiring;

public interface CustomerRegistrationService {

	void setAccountNumber(String accountNumber);
	void setAddress(String address);
	void setDebitCardNumber(String cardNumber);
	void register();
}
