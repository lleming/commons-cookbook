package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import junit.framework.Assert;

public class TransformCollectionTest {
    @Test
    public void testTransform() {
        Transformer transformer = new Transformer() {

            @Override
            public Object transform(Object input) {
                return StringUtils.reverse((String) input);
            }

        };

        Collection list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("three");
        CollectionUtils.transform(list, transformer);
        Iterator iterator = list.iterator();
        Assert.assertEquals("eno", iterator.next());
        Assert.assertEquals("owt", iterator.next());
        Assert.assertEquals("eerht", iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void testChainedTransformer() {
        Transformer reverse = new Transformer() {

            @Override
            public Object transform(Object input) {
                return StringUtils.reverse((String) input);
            }

        };

        Transformer nums = new Transformer() {

            @Override
            public Object transform(Object input) {
                return ((String) input) + " length: " + ((String) input).length();
            }

        };
        Transformer combo = new ChainedTransformer(new Transformer[] { reverse, nums });
        Collection list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("three");
        CollectionUtils.transform(list, combo);
        Iterator iterator = list.iterator();
        Assert.assertEquals("eno length: 3", iterator.next());
        Assert.assertEquals("owt length: 3", iterator.next());
        Assert.assertEquals("eerht length: 5", iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }
}
