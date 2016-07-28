package com.astraltear.example;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomTest {

	public static void main(String[] args) {
		 double x = Math.random();
		  System.out.println("Double between 0.0 and 1.0: x = "+x);

		int r1 = (int) (Math.random()*5)+3;
		System.out.println("Integer between 3 and 8: r1 = "+r1);
	
		char r2 = (char) ((Math.random()*5)+3);
		System.out.println("Integer between 3 and 8: r2 = "+r2);
		
//		 String identifier = RandomStringUtils.randomAlphanumeric(20).toUpperCase();  
		 String identifier = RandomStringUtils.randomAlphanumeric(20);  
		 System.out.println(identifier);
		
	}

}
