package org.example;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {
    @Test
    public void testTrim() {
        String word = " \t \r Testing 1 2 3 ";
        Assert.assertEquals("Testing 1 2 3", StringUtils.trim(word));
    }

    @Test
    public void testTrimToNull() {
        String word = "\r\n";
        Assert.assertNull(StringUtils.trimToNull(word));
    }

    @Test
    public void testStrip() {
        String line = "-----------***---SHAZAM---***---------------";
        Assert.assertEquals("SHAZAM", StringUtils.strip(line, "-*"));
    }

    @Test
    public void testChopEndOfLine() {
        String word = "Hello\n";
        Assert.assertEquals("Hello", StringUtils.chomp(word));
    }

    @Test
    public void testChopLineBreak() {
        String word = "Another test\r\n";
        Assert.assertEquals("Another test", StringUtils.chop(word));
    }

    @Test
    public void testHeader() {
        int width = 30;
        String wrapper = StringUtils.repeat("*", width);
        String message = StringUtils.center("SHAZAM", width, "*");
        String header = StringUtils.join(new String[] { wrapper, message, wrapper }, "\r\n");
        Assert.assertEquals(
                "******************************\r\n" +
                        "************SHAZAM************\r\n" +
                        "******************************",
                header);
    }

    @Test
    public void testReverseString() {
        String word = "Hello there";
        Assert.assertEquals("ereht olleH", StringUtils.reverse(word));
    }

    @Test
    public void testReverseDelimited() {
        String word = "I am Susan.";
        Assert.assertEquals("Susan am I.", StringUtils.reverseDelimited(StringUtils.chomp(word, "."), ' ') + '.');
    }
}
