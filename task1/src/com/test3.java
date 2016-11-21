package com;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class test3 {
  
  @Test
  public void test() {
    Model t=new Model();
    t.setName("x*y");
    t.expression();
    t.setSim("!d/dx");
    assertEquals("y*1",t.derivative());
  }

}
