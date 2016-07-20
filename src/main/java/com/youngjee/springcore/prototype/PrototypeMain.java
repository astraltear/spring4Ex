package com.youngjee.springcore.prototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrototypeMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("springcore.prototype.xml");
		
		PrototypeBean restaurant1 = (PrototypeBean) context.getBean("prototypeBean");
		restaurant1.setWelcomNote("welcome prototype");
		restaurant1.greetCustomer();
		
		PrototypeBean restaurant2 = (PrototypeBean) context.getBean("prototypeBean");
		restaurant2.greetCustomer();
	}

}
