package com.youngjee.springcore.di;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.youngjee.springcore.first4.Student;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public Student studentDI1() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");
		
		Student studentDI = new Student("홍길동 DI", 20, hobbys);
		studentDI.setHeight(180);
		studentDI.setWeight(80);
		
		return studentDI;
	}
	
	@Bean
	public Student studentDI2() {
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("독서");
		hobbys.add("음악감상");
		
		Student studentDI = new Student("홍길순 DI",10, hobbys);
		studentDI.setHeight(120);
		studentDI.setWeight(20);
		
		return studentDI;
	}
}
