package com;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test8 {
	Model a = new Model();
	@Before
	public void setUp() throws Exception {
		a.setName("78855b");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExpression() {
		assertEquals("Error!",a.expression());
	}

}
