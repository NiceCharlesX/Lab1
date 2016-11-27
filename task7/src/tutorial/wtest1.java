package tutorial;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class wtest1 {
	@Before
	public void setUp() throws Exception {
	}
	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void test() {
		expcontrol a = new expcontrol("x+x*y*8+x^3+y-x+x*6");
		a.callsave();
		dercontrol b = new dercontrol("!d/d x",a.aexp);
		b.callder();
		b.callsimplification();
		assertEquals("1+1*y*8+3*x^2-1",b.callprint());
	}
}
