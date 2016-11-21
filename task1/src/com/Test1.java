package com;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class test1 {
  @Test
  public void test() {
    Model t=new Model();
    t.setName("x+x*y*8+x^3+y-x+x*6");
    t.expression();
    t.setSim("!d/dx");
    assertEquals("y*8+x*x*3+6",t.derivative());
  }
}
