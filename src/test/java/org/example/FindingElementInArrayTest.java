package org.example;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

public class FindingElementInArrayTest {
    String[] colors = new String[] { "blue", "red", "green", "purple", "yellow", "cyan" };

    @Test
    public void testContains() {
        Assert.assertTrue("Must true", ArrayUtils.contains(colors, "red"));
    }

    @Test
    public void testContainsIsFalse() {
        Assert.assertFalse("Must false", ArrayUtils.contains(colors, "violet"));
    }

    @Test
    public void testIndexOf() {
        Assert.assertEquals("Must match", 2, ArrayUtils.indexOf(colors, "green"));
    }

    @Test
    public void testIndexOfNotFound() {
        Assert.assertEquals("Must not found", -1, ArrayUtils.indexOf(colors, "violet"));
    }
}
