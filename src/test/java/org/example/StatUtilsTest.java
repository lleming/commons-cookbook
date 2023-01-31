package org.example;

import org.apache.commons.math.stat.StatUtils;
import org.junit.Assert;
import org.junit.Test;
public class StatUtilsTest {
    double[] values = new double[] { 1, 2, 2, 2, 3, 14 };

    @Test
    public void testMin() {
        Assert.assertEquals(1.0, StatUtils.min(values), 0.00001);
    }

    @Test
    public void testMax() {
        Assert.assertEquals(14.0, StatUtils.max(values), 0.001);
    }

    @Test
    public void testMean() {
        Assert.assertEquals(4.0, StatUtils.mean(values), 0.001);
    }

    @Test
    public void testProduct() {
        Assert.assertEquals(336.0, StatUtils.product(values), 0.0001);
    }

    @Test
    public void testSum() {
        Assert.assertEquals(24.0, StatUtils.sum(values), 0.0001);
    }

    @Test
    public void testVariance() {
        Assert.assertEquals(24.4, StatUtils.variance(values), 0.000001);
    }
}
