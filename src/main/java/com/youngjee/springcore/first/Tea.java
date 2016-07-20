package com.youngjee.springcore.first;

public class Tea implements IHotDrink {

	@Override
	public void prepareHotDrink() {
		System.out.println("Dear Customer, we are preparing Tea for You!!!");
	}

}
