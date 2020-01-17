package com.sj.time;

import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtilsTest {

    @Test
    public void formatTime() {
        long checkInTime = 9 * DateTimeUtils.HOUR;
        System.out.println(DateTimeUtils.formatTime(checkInTime));

        long time = DateTimeUtils.compoundTime(checkInTime);
        Date date = new Date();
        date.setTime(time);
        System.out.println(date);
    }

    @Test
    public void testcase02_Time() throws ParseException {
        Date date1 = new Date();
        System.out.println(date1);

        String str = DateTimeUtils.toISO8601(date1);
        System.out.println(DateTimeUtils.toISO8601(date1));

        Date date2 = DateTimeUtils.fromISO8601(str);
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
    public void testcase_DateTime_001() {
        Date now = new Date();
        System.out.println("timeInMs: " + now.getTime());
        System.out.println(now);
        System.out.println();

        long dayDate = DateTimeUtils.getDayDate(now);
        System.out.println("date 1: " + dayDate);
        System.out.println(new Date(dayDate));
        System.out.println();

        long dayTime = DateTimeUtils.getDayTime(now);
        System.out.println("time 1: " + dayTime);
        System.out.println(new Date(dayTime));
        System.out.println();

        long dayTime2 = DateTimeUtils.getDayTime(now);
        System.out.println("time 2: " + dayTime2);
        System.out.println(new Date(dayTime2));
        System.out.println();

        long dayDate2 = DateTimeUtils.getDayDate(now);
        System.out.println("date 2: " + dayDate2);
        System.out.println(new Date(dayDate2));
    }
}