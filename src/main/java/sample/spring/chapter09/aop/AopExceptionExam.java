package sample.spring.chapter09.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopExceptionExam {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext_chapter09_aop.xml");
		AopService2 aopService2 = (AopService2) context.getBean("AopService2");
		
		try {
			aopService2.afterAdviceTest();
			aopService2.callExcept();
		} catch (Exception e) {
		}
		
				
	}

}
