package tutorial;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class btest3 {
	expcontrol a = new expcontrol("x+");
	@Before
	public void setUp() throws Exception {
	}
	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void test() {
		assertEquals(false,a.callcheck());
	}
}
