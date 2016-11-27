package tutorial;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class btest1 {
	expcontrol a = new expcontrol("x+y^5 - z*abc");
	@Before
	public void setUp() throws Exception {
	}
	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void test() {
		assertEquals(true,a.callcheck());
	}
}
