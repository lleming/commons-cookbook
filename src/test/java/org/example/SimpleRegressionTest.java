package org.example;

import org.apache.commons.math.MathException;
import org.apache.commons.math.stat.regression.SimpleRegression;
import org.junit.Assert;
import org.junit.Test;

public class SimpleRegressionTest {
  @Test
  public void testSimpleRegressionLinear() throws MathException {
    SimpleRegression regression = new SimpleRegression();
    regression.addData(0,0);
    regression.addData(1, 1.2);
    regression.addData(2, 2.6);
    regression.addData(3,3.2);
    regression.addData(4, 4);
    regression.addData(5,5);

    Assert.assertEquals("Intercept", 0.2381, regression.getIntercept(), 0.01);
    Assert.assertEquals("N", 6, regression.getN());
    Assert.assertEquals("Slope confidence interval", 0.169, regression.getSlopeConfidenceInterval(), 0.01);
    Assert.assertEquals("Slope", 0.971, regression.getSlope(), 0.01);
    Assert.assertEquals("Mean error", 0.065, regression.getMeanSquareError(), 0.01);
    Assert.assertEquals("R square", 0.985, regression.getRSquare(), 0.01);
  }

  @Test
  public void testSimpleRegressionNoneLinear() throws MathException {
    SimpleRegression regression = new SimpleRegression();
    regression.addData(400,100);
    regression.addData(300, 105);
    regression.addData(350, 70);
    regression.addData(200,50);
    regression.addData(4150, 300);
    regression.addData(50,500);

    Assert.assertEquals("Intercept", 162.146, regression.getIntercept(), 0.01);
    Assert.assertEquals("N", 6, regression.getN());
    Assert.assertEquals("Slope confidence interval", 0.15, regression.getSlopeConfidenceInterval(), 0.01);
    Assert.assertEquals("Slope", 0.02, regression.getSlope(), 0.01);
    Assert.assertEquals("Mean error", 36900.769, regression.getMeanSquareError(), 0.01);
    Assert.assertEquals("R square", 0.063, regression.getRSquare(), 0.01);
  }
}
