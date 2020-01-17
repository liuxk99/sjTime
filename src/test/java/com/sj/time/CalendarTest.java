package com.sj.time;

import java.util.Calendar;

public class CalendarTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void testcase_001() {
        Calendar calendar = Calendar.getInstance();
        System.out.println("date: " + calendar.getTime());

        int hour, minute, seconds, millisecond;
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
        seconds = calendar.get(Calendar.SECOND);
        millisecond = calendar.get(Calendar.MILLISECOND);

        System.out.println("hour: " + hour);
        System.out.println("minute: " + minute);
        System.out.println("seconds: " + seconds);
        System.out.println("millisecond: " + millisecond);
    }
}
