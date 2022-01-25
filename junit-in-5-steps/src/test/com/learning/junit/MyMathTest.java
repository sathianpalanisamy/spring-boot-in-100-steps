package com.learning.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

class MyMathTest {

	// absense of failure is suceess

	MyMath math = new MyMath();

	@Before
	public void before() {
		System.out.println("Before");
	}

	@After
	public void after() {
		System.out.println("After");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

	@Test
	void sumWithThreeNumbers() {
//		fail("Not yet implemented");
		System.out.println("test 1");
		assertEquals(10, math.sum(new int[] { 5, 4, 1 }));
	}

	@Test
	void sumWith1No() {
		System.out.println("test 2");
		assertEquals(10, math.sum(new int[] { 10 }));

	}

}
