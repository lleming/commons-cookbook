package org.example;

import static org.junit.Assert.*;

import org.apache.commons.math.complex.Complex;
import org.junit.Test;
public class ComplexNumbersTest {

  @Test
  public void testAdd() {
    Complex leftOperand = new Complex(2, 3);
    Complex rightOperand = new Complex(-2, 4);
    Complex expected = new Complex(0.0, 7.0);
    assertEquals(expected, leftOperand.add(rightOperand));
  }

  @Test
  public void testDivide() {
    Complex leftOperand = new Complex(2, 3);
    Complex rightOperand = new Complex(-2, 4);
    Complex expected = new Complex(0.4, -0.7);
    assertEquals(expected, leftOperand.divide(rightOperand));
  }

  @Test
  public void testMultiply() {
    Complex leftOperand = new Complex(2, 3);
    Complex rightOperand = new Complex(-2, 4);
    Complex expected = new Complex(-16.0, 2.0);
    assertEquals(expected, leftOperand.multiply(rightOperand));
  }

  @Test
  public void testSubstract() {
    Complex leftOperand = new Complex(2, 3);
    Complex rightOperand = new Complex(-2, 4);
    Complex expected = new Complex(4.0, -1.0);
    assertEquals(expected, leftOperand.subtract(rightOperand));
  }
}
