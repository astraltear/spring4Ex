package com.astraltear.example;

public abstract class Super {
	public void templateMethod() {
		hookMethod();
		abstractMethod();
	}
	
	protected void hookMethod() {}
	public abstract void abstractMethod();
}
