package com.youngjee.springcore.property;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SourcePropertyMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SourceToConfig.class);
		AdminProperty adminProperty = (AdminProperty) context.getBean("adminConfig");
		
		System.out.println(adminProperty.toString());
	}

}
