package com;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test7 {
	Model a = new Model();
	@Before
	public void setUp() throws Exception {
		a.setName("x1235+x^2");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExpression() {
		assertEquals("Error!",a.expression());
	}

}
