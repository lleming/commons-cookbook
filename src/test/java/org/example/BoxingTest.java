package org.example;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

public class BoxingTest {
    @Test
    public void boxingTest() {
        long[] array = new long[]{13, 56, 789};
        Long[] object = ArrayUtils.toObject(array);
        Assert.assertEquals("Match match", object[0], Long.valueOf(13));
    }

    @Test
    public void unboxingTest() {
        Long[] array = new Long[]{new Long(13), new Long(56), new Long(789)};
        long[] primitive = ArrayUtils.toPrimitive(array);
        Assert.assertTrue("Match match", primitive[0]==13);
    }
}
