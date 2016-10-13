package com.astraltear.callback;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.astraltear.callback.Calculator;

public class CalcSumTest {
	
	Calculator calculator;
	String numberFilePath;

	@Before
	public void setUp() throws Exception {
		this.calculator = new Calculator();
		this.numberFilePath = getClass().getResource("numbers.txt").getPath();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void sumNumber() throws Exception {
		assertThat(calculator.calcSum(this.numberFilePath), is(10));
	}
	
	@Test
	public void multiplyNumber() throws Exception {
		assertThat(calculator.calcMultiply(this.numberFilePath), is(24));
	}

	
	@Test
	public void concat() throws Exception {
		assertThat(calculator.concat(this.numberFilePath), is("1234"));
	}
	
}
