package org.example;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

import junit.framework.Assert;

public class ArrayPrintTest {

    @Test
    public void testPrintArray() {
        int[] array = new int[] { 7, 13, 22, 3, 5, 9, 8 };
        String arrayString = ArrayUtils.toString(array);
        Assert.assertEquals("Must match", "{7,13,22,3,5,9,8}", arrayString);
    }

    @Test
    public void testPrintMultidimensionalArray() {
        int[][] array = new int[][] {
                { 1 },
                { 8, 12 },
                { 6, 31, 9 },
                { 17 }
        };
        String arrayString = ArrayUtils.toString(array);
        Assert.assertEquals("Must match", "{{1},{8,12},{6,31,9},{17}}", arrayString);
    }

    @Test
    public void testPrintStringArray() {
        String[] colors = new String[] { "green", "blue", "yellow", "black", "purple", null };
        String colorsString = ArrayUtils.toString(colors, "Unknown");
        Assert.assertEquals("Must match", "{green,blue,yellow,black,purple,Unknown}", colorsString);
    }

}
