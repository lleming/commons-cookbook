package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.iterators.FilterIterator;
import org.junit.Assert;
import org.junit.Test;

public class FilterIteratorTest {
    @Test
    public void testFilterIterator() {

        Collection<Integer> numbers = Arrays.asList(1, 2, 4, 7, 9, 12, 18, 22);
        Iterator numbersIterator = numbers.iterator();
        Predicate oddOnly = new Predicate() {

            @Override
            public boolean evaluate(Object object) {
                if (object instanceof Integer) {
                    Integer number = (Integer) object;
                    return number % 2 == 0;
                }
                return false;
            }

        };
        Iterator iter = new FilterIterator(numbersIterator, oddOnly);
        while (iter.hasNext()) {
            Integer value = (Integer) iter.next();
            Assert.assertTrue(value % 2 == 0);
        }
    }
}
