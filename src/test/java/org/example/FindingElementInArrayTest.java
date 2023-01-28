package org.example;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

import junit.framework.Assert;

public class FindingElementInArrayTest {
    String[] colors = new String[] { "blue", "red", "green", "purple", "yellow", "cyan" };

    @Test
    public void testContais() {
        Assert.assertTrue("Must true", ArrayUtils.contains(colors, "red"));
    }

    @Test
    public void TestContainsFailed() {
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
