package com.sj.time;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.print.attribute.standard.MediaSize;

public class DateTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void testcase_001() {
        Date now = new Date();
        TimeDump.dump(now);

        // Late
        Date date = (Date) now.clone();
        date.setHours(9);
        date.setMinutes(35);
        date.setSeconds(0);
        TimeDump.dump(date);
    }

    @Test
    public void testcase_TimeZone() {
        Date now = new Date();
        TimeDump.dump(now);

        System.out.println("timezone: " + now.getTimezoneOffset());
    }

    @Test
    public void testcase_UTC() {
        final Date currentTime = new Date();
        System.out.println(DateUtil.toISO8601(currentTime));

        System.out.println(currentTime.toGMTString());

        final SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a z");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println("UTC time: " + sdf.format(currentTime));
        System.out.println(DateUtil.toISO8601(currentTime));

        final String ISO_8601_DF = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ";
        final SimpleDateFormat sdf_iso_8601 = new SimpleDateFormat(ISO_8601_DF);
        sdf_iso_8601.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println("UTC time: " + sdf_iso_8601.format(currentTime));
    }

    @Test
    public void testcase_003() {
        final Date now = new Date(System.currentTimeMillis());
        TimeDump.dump(now);
    }

    @Test
    public void testcase_004() {
        long currentTime = System.currentTimeMillis();
        System.out.println("currentTime: " + currentTime + " milliseconds");
    }
}
