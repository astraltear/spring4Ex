package com.youngjee.springcore.aop1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Aop1Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("springcore.aop1.xml");
		StudentDTO studentDTO = (StudentDTO) context.getBean("student");
		studentDTO.getStudentInfo();
		
		WorkerDTO workerDTO = (WorkerDTO) context.getBean("worker");
		workerDTO.getWorkerInfo();

	}

}
