package com.astraltear.collections;

public class EnumTest {

	public static void main(String[] args) {
		Buy.Status currentStatus = Buy.Status.valueOf("WT");
		System.out.println(currentStatus);
		
		switch(currentStatus) {
		case WT:
			System.out.println("is WT");
			break;
			
		case DN:
			System.out.println("is DN");
			break;
			
		case FL:
			System.out.println("is FL");
			break;
		}
	}

}
