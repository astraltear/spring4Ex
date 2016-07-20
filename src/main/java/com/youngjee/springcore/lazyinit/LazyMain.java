package com.youngjee.springcore.lazyinit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LazyMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springcore.lazyinit.xml");
		
		System.out.println("LazyMain INIT!!!!!");
		
		context.getBean("secondBean");

	}

}
