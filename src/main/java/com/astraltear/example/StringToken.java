package com.astraltear.example;

import java.util.Enumeration;
import java.util.StringTokenizer;

public class StringToken {

	public static void main(String[] args) {

/*		StringTokenizer lm_oTokenizer = new StringTokenizer("adbdfeere", "-");
		String[] lm_sReturns = new String[lm_oTokenizer.countTokens()];
		for(int i=0; lm_oTokenizer.hasMoreTokens(); i++) {
			lm_sReturns[i] = lm_oTokenizer.nextToken();
		}//for
		
		System.out.println("lm_sReturns[0]:"+lm_sReturns[0]);
		System.out.println("lm_sReturns[1]:"+lm_sReturns[1]);*/
		
		
		String phone="011-11-11";
		String output="";
		
		if (phone.length() > 4) {
			output= phone.substring(0, phone.length()-4)+"xxxx";
		} else {
			output="";
		}
		System.out.println("output:"+output);
		
		
		String[] array;
		array="ar,2,d".split(",");
		
		String userId="";
	    String password="";
	    String email="";
		System.out.println("array.length:"+array.length);
		if (array.length==1) {
			userId=array[0];
		} else if (array.length==2) {
			userId=array[0];
			password=array[1];
		} else if (array.length==3) {
			userId=array[0];
			password=array[1];
			email=array[2];
			
		}
		
		System.out.format("userId:%s, password:%s, email:%s", userId,password,email);
		
	}

}
