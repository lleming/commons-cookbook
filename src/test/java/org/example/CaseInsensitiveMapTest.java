package org.example;

import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.CaseInsensitiveMap;
import org.junit.Test;

import junit.framework.Assert;

public class CaseInsensitiveMapTest {
    @Test
    public void testCaseInsensitiveMap() {
        Map map = new CaseInsensitiveMap();
        map.put("one", "This is one");
        Assert.assertEquals("This is one", map.get("one"));
        Assert.assertEquals("This is one", map.get("ONE"));
        Assert.assertEquals("This is one", map.get("One"));

        Set keys = map.keySet();
        Assert.assertEquals("one", keys.iterator().next());

        map.put("One", "this is the second");
        Assert.assertEquals("one", map.keySet().iterator().next());
    }
}
