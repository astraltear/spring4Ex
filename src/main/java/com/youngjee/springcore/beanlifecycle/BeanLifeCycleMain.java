package com.youngjee.springcore.beanlifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleMain {
 
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springcore.beanlifecycle.xml");
		
		((AbstractApplicationContext)context).registerShutdownHook(); // destroy call 
		
		
		LifeCycleBean  cycleBean = (LifeCycleBean) context.getBean("lifecycleBean");
		cycleBean.greetCustomer();
	}

}
