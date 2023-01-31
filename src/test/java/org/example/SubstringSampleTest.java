package org.example;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class SubstringSampleTest {
    @Test
    public void testSubstring() {
        String html = "<html>" +
                "<head>" +
                "<title>Demo page</title>" +
                "</head>" +
                "<body>" +
                "<h1>This is demo page</h1>" +
                "</body>" +
                "</html>";
        String title = StringUtils.substringBetween(html, "<title>", "</title>");
        Assert.assertEquals("Demo page", title);
    }

    @Test
    public void testSubstrings() {
        String content = "{12}, {22}, {44}";
        String[] nums = StringUtils.substringsBetween(content, "{", "}");
        Assert.assertArrayEquals(new String[] { "12", "22", "44" }, nums);
    }
}
