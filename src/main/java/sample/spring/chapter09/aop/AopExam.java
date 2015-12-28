package sample.spring.chapter09.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopExam {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext_chapter09_aop.xml");
//		AopService aopService = context.getBean(AopService.class);
		AopService aopService = (AopService) context.getBean("AopService");
		
		aopService.methodCallOne("Exam",50);
		
		MockDTO dto = new MockDTO();
		dto.setName("Choi");
		dto.setAge(20);
		dto.setMan(true);
		
		aopService.methodCallTwo(dto);
		
				
	}

}
