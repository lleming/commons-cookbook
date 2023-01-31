package org.example;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Assert;
import org.junit.Test;

public class BeanUtilsTest {
    @Test
    public void testCloneBean()
            throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Book book = new Book();
        book.setTitle("Haskell for newbies");
        Book cloned = (Book) BeanUtils.cloneBean(book);
        Assert.assertEquals(cloned.getTitle(), book.getTitle());
        Assert.assertNotSame(cloned, book);
    }
}
