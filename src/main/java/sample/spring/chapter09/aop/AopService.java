package sample.spring.chapter09.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("AopService")
public class AopService {

	private static Logger logger = LoggerFactory.getLogger(AopService.class);
	
	public void methodCallOne(String title, int count) {
		logger.info("methodCallOne !!");
	}
	
	
	public void methodCallTwo(MockDTO dto) {
		logger.info("methodCallTwo !!");
	}
	
	public int returnMethodCallThree() {
		return 999;
	}
	
}
