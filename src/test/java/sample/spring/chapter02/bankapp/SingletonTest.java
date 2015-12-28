package sample.spring.chapter02.bankapp;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.spring.chapter02.bankapp.controller.FixedDepositController;
import sample.spring.chapter02.bankapp.dao.FixedDepositDao;

public class SingletonTest {
	private static ApplicationContext context;
	
	@BeforeClass
	public static void init() {
		context = new ClassPathXmlApplicationContext("classpath:applicationContext_chapter02.xml");
	}
	
	@Test
	public void testInstance() {
		FixedDepositController controller1 = (FixedDepositController) context.getBean("controller");
		FixedDepositController controller2 = (FixedDepositController) context.getBean("controller");
		
		Assert.assertSame("controller is same", controller1, controller2);
	}
	
	
	@Test
	public void testReference() {
		FixedDepositController controller = (FixedDepositController) context.getBean("controller");
		
		FixedDepositDao fixedDepositDao1 = controller.getFixedDepositService().getFixedDepositDao();
		FixedDepositDao fixedDepositDao2 = (FixedDepositDao) context.getBean("dao");
		
		Assert.assertSame("dao is same", fixedDepositDao1, fixedDepositDao2);
		
	}
	
	@Test
	public void testSingletonScope() {
		ApplicationContext anotherContext  = new ClassPathXmlApplicationContext("classpath:applicationContext_chapter02.xml");
		
		FixedDepositController controller1 = (FixedDepositController) context.getBean("controller");
		FixedDepositController controller2 = (FixedDepositController) anotherContext.getBean("controller");
		
		Assert.assertNotSame("another Context instance ", controller1, controller2);
	}
	
	
	@Test
	public void testPrototypeInstance() {
		FixedDepositDao fixedDepositDao1 = (FixedDepositDao) context.getBean("proto_dao");
		FixedDepositDao fixedDepositDao2 = (FixedDepositDao) context.getBean("proto_dao");
		
		Assert.assertNotSame("Scope Prototype Not Same", fixedDepositDao1, fixedDepositDao2);
	}
	
}
