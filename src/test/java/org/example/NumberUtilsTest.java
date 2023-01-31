package org.example;

import org.apache.commons.lang.math.NumberUtils;
import org.junit.Assert;
import org.junit.Test;
public class NumberUtilsTest {
    double[] arr = new double[] { 0.2, 0.4, 0.5, -3.0, 4.233, 4.226 };

    @Test
    public void testMinArray() {
        double min = NumberUtils.min(arr);
        double expected = -3.0;
        Assert.assertEquals(expected, min, 0.0000001);
    }

    @Test
    public void testMaxArray() {
        double max = NumberUtils.max(arr);
        double expected = 4.233;
        Assert.assertEquals(expected, max, 0.0000001);
    }
}
