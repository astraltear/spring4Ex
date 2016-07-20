package com.youngjee.springcore.property;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PropertyMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("springcore.property.xml");
		
		AdminProperty adminProperty = (AdminProperty) context.getBean("adminProperty");
		
		System.out.println(adminProperty.toString());

	}

}
