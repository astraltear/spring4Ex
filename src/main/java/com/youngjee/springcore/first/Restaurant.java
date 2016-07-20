package com.youngjee.springcore.first;

import java.util.List;

public class Restaurant {
	
	IHotDrink hotDrink;
	private List restaurantWaitersList;
	
	public Restaurant(IHotDrink hotDrink) {
		this.hotDrink = hotDrink;
	}
	
	public void prepareHotDrink() {
		hotDrink.prepareHotDrink();
	}
	
	

	public void setRestaurantWaitersList(List restaurantWaitersList) {
		this.restaurantWaitersList = restaurantWaitersList;
	}

	public void displayWaitersNames() {
		System.out.println("All waiters working in Restaurant: "+restaurantWaitersList);
	}

}
