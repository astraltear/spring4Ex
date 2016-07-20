package com.youngjee.springcore.first3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("springcore.first3.xml");
		
		Pencil pencil = context.getBean("pencil6",Pencil.class);
		pencil.use();
		
		Pencil pencil2 = (Pencil) context.getBean("pencil6bE");
		pencil2.use();
	}

}
