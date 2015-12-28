package sample.spring.chapter04.autowiring;

import org.apache.log4j.Logger;

public class CustomerRegistrationDaoImpl implements CustomerRegistrationDao {
	
	private static Logger logger = Logger.getLogger(CustomerRegistrationDaoImpl.class);

	public CustomerRegistrationDaoImpl() {
		logger.info("Created CustomerRegistrationDaoImpl instance");
	}

	@Override
	public void registerCustomer(CustomerRegistrationDetails customerRegistrationDetails) {

	}

}
