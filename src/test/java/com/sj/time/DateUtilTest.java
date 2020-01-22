package com.sj.time;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testcase02_Time() throws ParseException {
        Date date1 = new Date();
        System.out.println(date1);

        String str = DateUtil.toISO8601(date1);
        System.out.println(DateUtil.toISO8601(date1));

        Date date2 = DateUtil.fromISO8601(str);
        System.out.println(date2);

        Assert.assertEquals(date2, date1);
    }

    @Test
    public void testcase03_time() throws ParseException {
        String dateStr2 = "2012-05-31T13:48:04Z";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date d = sdf.parse(dateStr2);
        System.out.println(d);
    }

    @Test
    public void testcase_Days() {
        // Today Date
        Date date = DateUtil.getDate();
        System.out.println(date);

        // Yesterday
        Date yesterday = DateUtil.yesterday();
        System.out.println(yesterday);

        // Tomorrow
        Date tomorrow = DateUtil.tomorrow();
        System.out.println(tomorrow);
    }
}