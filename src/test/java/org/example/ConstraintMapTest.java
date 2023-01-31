package org.example;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.AllPredicate;
import org.apache.commons.collections.functors.AnyPredicate;
import org.apache.commons.collections.functors.EqualPredicate;
import org.apache.commons.collections.functors.InstanceofPredicate;
import org.apache.commons.collections.functors.NotPredicate;
import org.apache.commons.collections.functors.OnePredicate;
import org.apache.commons.collections.functors.OrPredicate;
import org.apache.commons.collections.map.PredicatedMap;
import org.junit.Assert;
import org.junit.Test;

public class ConstraintMapTest {
    @Test
    public void testConstraintMap() {
        Predicate green = new EqualPredicate("green");
        Predicate blue = new EqualPredicate("blue");
        Predicate notRed = new NotPredicate(new EqualPredicate("red"));
        Predicate colors = new AnyPredicate(new Predicate[] { green, blue, notRed });

        Predicate onlyNames = new InstanceofPredicate(Name.class);

        Map map = new HashMap();
        Map safeMap = PredicatedMap.decorate(map, colors, onlyNames);

        safeMap.put("green", new Name("Gintelshtain"));
        Assert.assertEquals(1, safeMap.size());
        try {
            safeMap.put("red", new Name("Redmond"));
        } catch (Exception e) {
            Assert.assertEquals(IllegalArgumentException.class, e.getClass());
        }

        try {
            safeMap.put("blue", "Interactino");
        } catch (Exception e) {
            Assert.assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    static class Name {
        private String value;

        public Name(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }
}
