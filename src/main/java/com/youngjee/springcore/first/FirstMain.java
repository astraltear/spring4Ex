package com.youngjee.springcore.first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:./springcore.first.xml");
		
		Restaurant restaurant = (Restaurant) context.getBean("restaurantBean");
		
		restaurant.prepareHotDrink();
		restaurant.displayWaitersNames();
		
	}

}
