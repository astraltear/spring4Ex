package com.astraltear.test;

import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import com.astraltear.configuration.UserDTO;


/*
 * Before - Test - After 순으로 반복된다.
 * 매번 새로운 객체가 생성된다.
 */

public class UserDaoTest {
	
	@Before
	public void setup() {
		System.out.println("Before!!");
		System.out.println(this);
	}


	@Test
	public void test1() {
		UserDTO dto1 = new UserDTO();
		dto1.setUserId("astraltear");
		
		UserDTO dto2 = new UserDTO();
		dto2.setUserId("astraltear");
		
		assertThat(dto1.getUserId(), is(dto2.getUserId()));
		System.out.println("test1");
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
	}
	
	@Test
	public void test3() {
		System.out.println("test3");
	}
	
	@After
	public void tearDown() {
		System.out.println("tearDown!!\n");
	}

}
