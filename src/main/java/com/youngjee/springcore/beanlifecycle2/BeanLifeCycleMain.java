package com.youngjee.springcore.beanlifecycle2;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.youngjee.springcore.first4.Student;

public class BeanLifeCycleMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("springcore.beanlifecycle2.xml");
		context.refresh();
		
		Student student = (Student) context.getBean("student_lifecycle");
		System.out.println(student.toString());
		
		OtherStudent otherStudent = (OtherStudent) context.getBean("other_student");
		System.out.println(otherStudent.toString());
		
		context.close();
	}

}
