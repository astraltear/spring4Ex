package sample.spring.chapter04.lookupmethod;

import org.apache.log4j.Logger;

public class CustomerRequestDaoImpl implements CustomerRequestDao {
	private static Logger logger = Logger.getLogger(CustomerRequestDaoImpl.class);
	
	public CustomerRequestDaoImpl() {
		logger.info("Created CustomerRequestDaoImpl instance");
	}

	@Override
	public void submitRequest(CustomerRequestDetails userRequestDetails) {
		// TODO Auto-generated method stub

	}

}
