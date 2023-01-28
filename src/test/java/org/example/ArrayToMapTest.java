package org.example;

import java.util.Map;
import org.apache.commons.lang.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

public class ArrayToMapTest {
    @Test
    public void testTwoDimensionalArrayToMap() {
        Object[][] data = new Object[][] {
            {"L", 10.0},
            {"H", 12.74},
            {"Li", 322.1},
            {"Sr", 17.34}
        };
        Map map = ArrayUtils.toMap(data);

        Double li = (Double) map.get("Li");
        Assert.assertEquals(322.1, li);

        Assert.assertNull(map.get("Tb"));
    }
}
