
package com;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//expression test
public class expressiontest1 {
	Model a = new Model();
	@Before
	public void setUp() throws Exception {
	a.setName("x+y^5 - z*abc");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExpression() {
		 assertEquals("Right!",a.expression());
	}

}
