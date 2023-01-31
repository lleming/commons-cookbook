package org.example;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.list.PredicatedList;
import org.junit.Test;

import junit.framework.Assert;

public class ConstraintListTest {
    @Test
    public void testConstraintList() {
        Predicate odd = new Predicate() {

            @Override
            public boolean evaluate(Object object) {
                Integer value = (Integer) object;
                return value % 2 == 0;
            }

        };

        List list = new ArrayList<>();
        List oddList = PredicatedList.decorate(list, odd);
        oddList.add(2);
        oddList.add(4);
        Assert.assertEquals(2, list.size());
        try {
            list.add(3);
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }

    }
}
