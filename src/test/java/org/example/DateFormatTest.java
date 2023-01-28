package org.example;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.junit.Assert;
import org.junit.Test;

public class DateFormatTest {
    Calendar calendar = Calendar.getInstance();
    {
        calendar.set(2022, 0, 24, 12, 32, 56);
    }

    @Test
    public void testDateFormat() {
        String dateString = DateFormatUtils.ISO_DATETIME_FORMAT.format(calendar);
        Assert.assertEquals("2022-01-24T12:32:56", dateString);
    }

    @Test
    public void testCustomDateFormat() {
        FastDateFormat format = FastDateFormat.getInstance("yyyy---DD---mm");
        String dateString = format.format(calendar);
        Assert.assertEquals("2022---24---32", dateString);

    }

    @Test
    public void testTruncateDate() {
        Calendar date = DateUtils.round(calendar, Calendar.HOUR);
        String stringDate = date.getTime().toString();
        Assert.assertEquals("Mon Jan 24 13:00:00 GMT 2022", stringDate);
    }
}
