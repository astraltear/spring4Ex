package com.youngjee.springcore.aop2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.youngjee.springcore.aop2.StudentDTO;
import com.youngjee.springcore.aop2.WorkerDTO;

public class Aop2Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("springcore.aop2.xml");
		StudentDTO studentDTO = (StudentDTO) context.getBean("student");
		studentDTO.getStudentInfo();
		
		WorkerDTO workerDTO = (WorkerDTO) context.getBean("worker");
		workerDTO.getWorkerInfo();
		
		context.close();
	}

}
