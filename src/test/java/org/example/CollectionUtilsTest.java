package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.functors.EqualPredicate;
import org.junit.Test;

import junit.framework.Assert;

public class CollectionUtilsTest {
    @Test
    public void testCount() {
        List list = Arrays.asList("A", "B", "A", "C", "D", "B", "B", "B", "E", "F", "G");
        Predicate b = new EqualPredicate("B");
        Assert.assertEquals(4, CollectionUtils.countMatches(list, b));
    }

    @Test
    public void testCardinality() {
        List list = Arrays.asList("A", "B", "A", "C", "D", "B", "B", "B", "E", "F", "G");
        int actual = CollectionUtils.cardinality("A", list);
        Assert.assertEquals(2, actual);
    }

    @Test
    public void testFrequenceMap() {
        List list = Arrays.asList("A", "B", "A", "C", "D", "B", "B", "B", "E", "F", "G");
        Map frequencies = CollectionUtils.getCardinalityMap(list);
        Assert.assertEquals(2, frequencies.get("A"));
        Assert.assertEquals(1, frequencies.get("C"));
        Assert.assertEquals(1, frequencies.get("G"));
        Assert.assertEquals(4, frequencies.get("B"));
        Assert.assertNull(frequencies.get("M"));
        Assert.assertEquals("Total 7 unique elements: A B C D E F G", 7, frequencies.size());
    }

    @Test
    public void testSetIntersection() {
        Set left = new HashSet(Arrays.asList("A", "B", "G", "E", "F", "M"));
        Set right = new HashSet(Arrays.asList("B", "G", "Y", "Z"));
        Collection common = CollectionUtils.intersection(left, right);
        Assert.assertEquals(2, common.size());
        Comparator comparator = ComparatorUtils.naturalComparator();
        String[] commonLetters = (String[]) common.toArray(new String[0]);
        Arrays.sort(commonLetters, comparator);
        Collection actual = Arrays.asList(commonLetters);
        Assert.assertEquals(Arrays.asList("B", "G"), actual);

    }

    @Test
    public void testUnion() {
        Set left = new HashSet(Arrays.asList("A", "B", "G", "E", "F", "M"));
        Set right = new HashSet(Arrays.asList("B", "G", "Y", "Z"));
        Collection common = CollectionUtils.union(left, right);
        Assert.assertEquals(8, common.size());
        Comparator comparator = ComparatorUtils.naturalComparator();
        String[] commonLetters = (String[]) common.toArray(new String[0]);
        Arrays.sort(commonLetters, comparator);
        Collection actual = Arrays.asList(commonLetters);
        Assert.assertEquals(Arrays.asList("A", "B", "E", "F", "G", "M", "Y", "Z"), actual);
    }


    @Test
    public void testSubstruct() {
        Set left = new HashSet(Arrays.asList("A", "B", "G", "E", "F", "M"));
        Set right = new HashSet(Arrays.asList("B", "G", "Y", "Z"));
        Collection common = CollectionUtils.subtract(left, right);
        Assert.assertEquals(4, common.size());
        Comparator comparator = ComparatorUtils.naturalComparator();
        String[] commonLetters = (String[]) common.toArray(new String[0]);
        Arrays.sort(commonLetters, comparator);
        Collection actual = Arrays.asList(commonLetters);
        Assert.assertEquals(Arrays.asList("A", "E", "F", "M"), actual);
    }

    @Test
    public void testDisjunction() {
        Set left = new HashSet(Arrays.asList("A", "B", "G", "E", "F", "M"));
        Set right = new HashSet(Arrays.asList("B", "G", "Y", "Z"));
        Collection common = CollectionUtils.disjunction(left, right);
        Assert.assertEquals(6, common.size());
        Comparator comparator = ComparatorUtils.naturalComparator();
        String[] commonLetters = (String[]) common.toArray(new String[0]);
        Arrays.sort(commonLetters, comparator);
        Collection actual = Arrays.asList(commonLetters);
        Assert.assertEquals(Arrays.asList("A", "E", "F", "M", "Y", "Z"), actual);
    }
}
