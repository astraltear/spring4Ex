package com.youngjee.springcore.beanpostprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanPostProcessorMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springcore.beanpostprocessor.xml");
		
		((AbstractApplicationContext) context).registerShutdownHook();
		
		PostBean postBean = (PostBean) context.getBean("postBean");
		postBean.greetCustomer();

	}

}
