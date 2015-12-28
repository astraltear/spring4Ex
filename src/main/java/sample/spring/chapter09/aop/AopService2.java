package sample.spring.chapter09.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("AopService2")
public class AopService2 {

	private static Logger logger = LoggerFactory.getLogger(AopService2.class);
	
	public void callExcept() throws Exception {
		int a = 2/0;
	}
	
	
	public void afterAdviceTest() {
		logger.info("AopService2 afterAdviceTest");
	}

}
