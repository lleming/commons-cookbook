package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.collections.iterators.UniqueFilterIterator;
import org.junit.Test;

import junit.framework.Assert;

public class UniqueIteratorTest {
    @Test
    public void testUniqueElementsIterator() {

        Collection names = Arrays.asList("alex", "ronaldo", "guadiola", "ben", "alex", "shakira", "ronaldo");
        Iterator namesIterator = names.iterator();
        Iterator uniqueNames = new UniqueFilterIterator(namesIterator);

        Collection uniqueNamesCollection = new ArrayList<>();
        while (uniqueNames.hasNext()) {
            uniqueNamesCollection.add(uniqueNames.next());
        }
        Collection expected = Arrays.asList("alex", "ronaldo", "guadiola", "ben", "shakira");
        Assert.assertEquals(expected, uniqueNamesCollection);
    }
}
