package org.example;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import junit.framework.Assert;

public class StringUtilsStringTest {
    @Test
    public void testWord() {
        String word = "Virginia";
        Assert.assertTrue(StringUtils.isAlpha(word));
        Assert.assertFalse(StringUtils.isNumeric(word));
        Assert.assertTrue(StringUtils.isAlphanumeric(word));
        Assert.assertTrue(StringUtils.isAlphaSpace(word));
    }

    @Test
    public void testNumber() {
        String number = "1976";
        Assert.assertTrue(StringUtils.isNumeric(number));
        String word = "Mozart";
        Assert.assertFalse(StringUtils.isNumeric(word));
    }

    @Test
    public void testWordDifference() {
        String diff = StringUtils.difference("Word", "World");
        Assert.assertEquals("ld", diff);
    }

    @Test
    public void testIndexOfWordDifference() {
        Assert.assertEquals(3, StringUtils.indexOfDifference("Word", "World"));
    }

    @Test
    public void testLevenstainDiff() {
        Assert.assertEquals(1, StringUtils.getLevenshteinDistance("Word", "World"));
    }
}
