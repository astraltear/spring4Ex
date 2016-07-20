package com.youngjee.springcore.beanlifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifeCycleBean {

	public void greetCustomer() {
		System.out.println("WELCOME dear CUSTOMER!! THIS IS LIFECYCLE DEMO");
		
	}
	
	@PostConstruct
	public void init() {
		System.out.println("LifeCycleBean init!!!!");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("LifeCycleBean destroy!!!");
	}

}
