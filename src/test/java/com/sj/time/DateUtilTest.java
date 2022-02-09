package com.sj.time;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

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

        String strCanada = DateUtil.toISO8601(date1, Locale.CANADA);
        System.out.println(strCanada);
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

    /**
     * 传入Data类型日期，返回字符串类型时间（ISO8601标准时间）
     * @param date
     * @return
     */
    public static String getISO8601Timestamp(Date date){
        TimeZone tz = TimeZone.getTimeZone("Asia/Shanghai");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(tz);
        return df.format(date);
    }

    public static String toISO8601UTC(Date date) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(tz);
        return df.format(date);
    }

    @Test
    public void testcase_04_iso() {
        String iso8601Str = getISO8601Timestamp(new Date());
        System.out.println(iso8601Str);
    }

    @Test
    public void testcase_05_iso_utc() {
        Date myDate = new Date();
        System.out.println(myDate);
        String iso8601Str = toISO8601UTC(myDate);
        System.out.println(iso8601Str);
    }
}