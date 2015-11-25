package sample.spring.chapter06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Chapter06Exam {
	
	private static Logger logger = LoggerFactory.getLogger(Chapter06Exam.class);
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext_chapter06.xml");
		Sample sample = (Sample) context.getBean("sample");
		
		logger.debug(sample.toString());
		
	}
}
