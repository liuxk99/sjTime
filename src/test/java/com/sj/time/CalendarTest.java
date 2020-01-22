package com.sj.time;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

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
        TimeDump.dump(calendar.getTime());

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

    @Test
    public void testcase_002() {
        Date date = Calendar.getInstance().getTime();
        {
            date.setHours(18);
            date.setMinutes(40);
            TimeDump.dump(date);
        }

        // setTime
        Calendar calendar = Calendar.getInstance();
        calendar.setTime((Date) date.clone());
        TimeDump.dump(calendar.getTime());

        // setTimeInMillis
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(date.getTime());
        TimeDump.dump(calendar1.getTime());
    }

    @Test
    public void testcase_003() throws Exception {
        Calendar calendar = Calendar.getInstance();
        dumpDayOfWeek(calendar);

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        dumpDayOfWeek(calendar);
    }

    private void dumpDayOfWeek(Calendar calendar) {
        System.out.println("=> dumpDayOfWeek()");
        {
            System.out.println(calendar.toString());
            int firstDayOfWeek = calendar.getFirstDayOfWeek();
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            System.out.println("first day of week: " + firstDayOfWeek);
            System.out.println("day of week: " + dayOfWeek);
        }
        System.out.println("<- dumpDayOfWeek()");
    }
}
