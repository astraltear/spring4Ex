package com.youngjee.springcore.prototype;


public class PrototypeBean {
	
	private String welcomNote;

	public void setWelcomNote(String welcomNote) {
		this.welcomNote = welcomNote;
	}
	
	public void greetCustomer() {
		System.out.println(this.welcomNote);
	}

}
