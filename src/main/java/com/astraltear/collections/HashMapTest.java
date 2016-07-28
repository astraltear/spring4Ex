package com.astraltear.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		Map<String, String> loginUsers = new HashMap();
		loginUsers.put("a", "1");
		loginUsers.put("b", "2");
		loginUsers.put("b", "3");
		loginUsers.put("c", "4");
		
		
		Iterator<String> keys =  loginUsers.keySet().iterator();
		
		while (keys.hasNext()) {
			String key = keys.next();
			System.out.println( String.format("키 : %s, 값 : %s", key, loginUsers.get(key)) );
			
		}
	}

}
