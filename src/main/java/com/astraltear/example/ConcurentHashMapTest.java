package com.astraltear.example;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurentHashMapTest {

	public static void main(String[] args) {
		ConcurrentHashMap loginUsers = new ConcurrentHashMap();
		loginUsers.put("123", "abc");
		
		System.out.println( loginUsers.containsKey("123") );
		System.out.println( loginUsers.containsValue("abcd") );
		
	}

}
