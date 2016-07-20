package com.youngjee.springcore.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youngjee.springcore.first4.Student;

public class CodeDiMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Student di1 = (Student) context.getBean("studentDI1");
		System.out.println(di1.toString());
		
		Student di2 = (Student) context.getBean("studentDI2");
		System.out.println(di2.toString());
		
		context.close();
		/*
		org.springframework.context.annotation.AnnotationConfigApplicationContext- Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@100e398: startup date [Tue Dec 29 17:47:02 KST 2015]; root of context hierarchy
		DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Returning cached instance of singleton bean 'lifecycleProcessor'
		DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Destroying singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@1d4b8dea: defining beans [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,org.springframework.context.annotation.internalAutowiredAnnotationProcessor,org.springframework.context.annotation.internalRequiredAnnotationProcessor,org.springframework.context.annotation.internalCommonAnnotationProcessor,org.springframework.context.event.internalEventListenerProcessor,org.springframework.context.event.internalEventListenerFactory,applicationConfig,org.springframework.context.annotation.ConfigurationClassPostProcessor.importAwareProcessor,org.springframework.context.annotation.ConfigurationClassPostProcessor.enhancedConfigurationProcessor,studentDI1,studentDI2]; root of factory hierarchy
		 */
 
	}

}
