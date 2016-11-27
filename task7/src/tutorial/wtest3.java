package tutorial;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class wtest3 {
	@Before
	public void setUp() throws Exception {
	}
	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void test() {
		expcontrol a = new expcontrol("x*y");
		a.callsave();
		dercontrol b = new dercontrol("!d/d x",a.aexp);
		b.callder();
		b.callsimplification();
		assertEquals("1*y",b.callprint());
	}
}
