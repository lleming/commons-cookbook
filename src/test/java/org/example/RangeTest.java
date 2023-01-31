package org.example;

import org.apache.commons.lang.math.DoubleRange;
import org.apache.commons.lang.math.IntRange;
import org.apache.commons.lang.math.Range;
import org.junit.Assert;
import org.junit.Test;
public class RangeTest {
    @Test
    public void testRange() {
        Range range = new DoubleRange(22.34, 75.35);
        Assert.assertTrue(range.containsDouble(30.45));
        Assert.assertFalse(range.containsDouble(7.274));
        Assert.assertFalse(range.containsDouble(96.755));
        Assert.assertEquals(22, range.getMinimumInteger());
        Assert.assertEquals(75, range.getMaximumInteger());
    }

    @Test
    public void testContainsAnotherRange() {
        Range range = new IntRange(22, 75);
        Range withinRange = new IntRange(30, 40);
        Assert.assertTrue(range.containsRange(withinRange));
    }

    @Test
    public void testRangeExceedAnotherOnLeft() {
        Range range = new IntRange(22, 75);
        Range withinRange = new IntRange(5, 40);
        Assert.assertFalse(range.containsRange(withinRange));
    }

    @Test
    public void testRangeExceedAnotherOnRight() {
        Range range = new IntRange(22, 75);
        Range withinRange = new IntRange(30, 80);
        Assert.assertFalse(range.containsRange(withinRange));
    }

    @Test
    public void testRangesDontOverlap() {
        Range first = new IntRange(10, 20);
        Range second = new IntRange(21, 30);
        Assert.assertFalse(first.containsRange(second));
    }
}
