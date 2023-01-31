package org.example;

import java.util.Arrays;
import java.util.Collection;

import javax.swing.plaf.multi.MultiPanelUI;

import org.apache.commons.collections.MultiHashMap;
import org.apache.commons.collections.MultiMap;
import org.junit.Assert;
import org.junit.Test;

public class MultiValueTest {
    @Test
    public void testMultiMap() {
        MultiMap multiMap = new MultiHashMap();
        multiMap.put("ONE", new Object());
        multiMap.put("ONE", new Object());
        multiMap.put("TWO", new Object());
        Assert.assertEquals(2, ((Collection) multiMap.get("ONE")).size());
    }

    @Test
    public void testMultiMapRemove() {
        MultiMap multiMap = new MultiHashMap();
        multiMap.put("ONE", new Object());
        multiMap.put("ONE", new Object());
        multiMap.put("TWO", new Object());
        multiMap.remove("ONE");
        Assert.assertNull((Collection) multiMap.get("ONE"));
        multiMap.remove("TWO");
        Assert.assertNull((Collection) multiMap.get("TWO"));
        multiMap.put("THREE", "3");
        multiMap.put("THREE", "33");
        multiMap.put("THREE", "333");
        multiMap.put("FOUR", "4");
        multiMap.put("FOUR", "44");
        multiMap.put("FIVE", "5");
        Assert.assertEquals(3, ((Collection) multiMap.get("THREE")).size());
        // remove doesn't work 
        // https://stackoverflow.com/questions/30485387/i-am-trying-to-remove-a-single-value-from-a-multimaporg-apache-commons-collecti
        //multiMap.remove("THREE", "33");
        //Assert.assertEquals(Arrays.asList("3", "333"), multiMap.get("THREE"));
        //multiMap.remove("THREE", "333");
        //Assert.assertEquals(Arrays.asList("3"), multiMap.get("THREE"));
        //multiMap.remove("THREE", "3");
        //Assert.assertNull((Collection) multiMap.get("TWO"));
    }
}
