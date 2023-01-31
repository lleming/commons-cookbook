package org.example;

import org.apache.commons.lang.WordUtils;
import org.junit.Test;

import junit.framework.Assert;

public class WordUtilsTest {
    @Test
    public void testWrapTest() {
        String message = "One two three four five six seven eight nine ten";
        String wrappedString = WordUtils.wrap(message, 20, "\n", false);
        Assert.assertEquals(
                "One two three four\n" +
                        "five six seven eight\n" +
                        "nine ten",
                wrappedString);

    }
}
