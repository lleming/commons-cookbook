package org.example;

import org.apache.commons.lang.math.Fraction;
import org.junit.Assert;
import org.junit.Test;
public class FractionTest {
    @Test
    public void testFractions() {
        Fraction fraction = Fraction.getFraction("23 1/7");
        double expected = 23.142857142857142;
        Assert.assertEquals("Must reduce to double", expected, fraction.doubleValue(), 0.00001);
    }
    @Test
    public void testFractionMultiply() {
        Fraction leftOperand = Fraction.getFraction("6 1/3");
        Fraction rightOperand = Fraction.getFraction("1 2/5");
        Fraction result = leftOperand.multiplyBy(rightOperand);
        Fraction expected = Fraction.getFraction("133/15");
        Assert.assertEquals(leftOperand + " * " + rightOperand, expected, result);
    }

    @Test
    public void testFractionSum() {
        Fraction leftOperand = Fraction.getFraction("6 1/3");
        Fraction rightOperand = Fraction.getFraction("1 2/5");
        Fraction result = leftOperand.add(rightOperand);
        Fraction expected = Fraction.getFraction("116/15");
        Assert.assertEquals(leftOperand + " * " + rightOperand, expected, result);
    }

    @Test
    public void testFractionDivide() {
        Fraction leftOperand = Fraction.getFraction("6 1/3");
        Fraction rightOperand = Fraction.getFraction("1 2/3");
        Fraction result = leftOperand.divideBy(rightOperand);
        Fraction expected = Fraction.getFraction("19/5");
        Assert.assertEquals(leftOperand + " * " + rightOperand, expected, result);
    }

    @Test
    public void testFractionReduce() {
        Fraction leftOperand = Fraction.getFraction("120/24");
        Fraction expected = Fraction.getFraction("5");
        Assert.assertEquals("Reduce 120/24", expected, leftOperand.reduce());
    }
}
