package com.youngjee.springcore.first4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("springcore.first4.1.xml","springcore.first4.2.xml");
		
		Student student1 = (Student) context.getBean("student");
		System.out.println("student1:"+student1.toString());
		
		StudentInfo studentInfo = (StudentInfo) context.getBean("studentInfo1");
		Student student2 = studentInfo.getStudent();
		System.out.println("student2:"+student2.toString());
		
		if (student1.equals(student2)) {
			// scope="prototype">
			System.out.println("student1 equals student2 ");
		} else {
			// scope="prototype">
			System.out.println("student1 NOT equals student2 ");
		}
		
		Student student3 = (Student) context.getBean("student3");
		System.out.println("student3:"+student3.toString());
		
		if (student1.equals(student3)) {
			System.out.println("student1 equals student3 ");
		} else {
			System.out.println("student1 NOT equals student3 ");
		}
		
	}

}
