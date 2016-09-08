package com.astraltear.example;

import java.util.Arrays;
import java.util.List;

public class Example {

	public static void main(String[] args) {
		
		 String[] words = {"ace", "boom", "crew", "dog", "eon"};  

	      List<String> wordList = Arrays.asList(words);  
		
		
		if (wordList.contains("boom")) {
			System.out.println("in if");
		} else {
			System.out.println("else if");
		}
		
		BbsDTO bbsDTO = new BbsDTO();
		bbsDTO.setLinkUrl(null);
		try {
			if(bbsDTO.getLinkUrl() == null ||("").equals(bbsDTO.getLinkUrl())) {
				System.out.println("IN IF");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("END!!!");
	}

}
