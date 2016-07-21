package com.astraltear.example;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodingTest {

	public static void main(String[] args) {
		String [] types = {"UTF-8","EUC-KR","ISO-8859-1"};
		String testValue = "�ѱ�";
		System.out.println("default character : " + testValue);
		String encode_result = null;
		System.out.println("------TEST START------");

		try {
			for(String type : types){
				encode_result = URLEncoder.encode(testValue, type);
				System.out.println("encode with " + type +" : "+ URLEncoder.encode(testValue, type));

					for(String type2 : types){
						System.out.println("decode with " + type2 +" : "+ URLDecoder.decode(encode_result, type2));		
					}	
					System.out.println("--------------------");		
			}	

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();

		}
		
		System.out.println("------TEST END------");

	}

}
