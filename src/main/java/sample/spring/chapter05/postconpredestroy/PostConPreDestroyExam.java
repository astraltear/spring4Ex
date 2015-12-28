package sample.spring.chapter05.postconpredestroy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PostConPreDestroyExam {

	public static void main(String[] args) throws Exception {
		
//		아래의 컨테이너로 호출시 @PostConstruct 만 호출된다  @PreDestroy는 호출되지 않는다. 
//		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext_chapter05_postconpredestroy.xml");

		
//		registerShutdownHook 메소드는 standalone한 어플리케이션에서만 사용해야 한다.
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext_chapter05_postconpredestroy.xml");
		context.registerShutdownHook();
		
		FixedDepositService fixedDepositService = (FixedDepositService) context.getBean("fixedDepositService");
		fixedDepositService.createFixedDeposit(new FixedDepositDetails(1, 1000, 12, "abc@abc.com"));
		
	}

}
