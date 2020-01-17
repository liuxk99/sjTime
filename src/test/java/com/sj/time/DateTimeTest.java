package com.sj.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class DateTimeTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void testcase_002() {
        Date date = Calendar.getInstance().getTime();
        {
            date.setHours(18);
            date.setMinutes(40);
            DumpUtils.dump(date);
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime((Date) date.clone());
        DumpUtils.dump(calendar.getTime());

        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(date.getTime());
        DumpUtils.dump(calendar1.getTime());
    }

    @Test
    public void testcase_003() {
        Calendar calendar = Calendar.getInstance();
        DumpUtils.dump(calendar.getTime());

        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
    }

}
