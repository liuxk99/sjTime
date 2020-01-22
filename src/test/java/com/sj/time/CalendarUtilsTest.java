package com.sj.time;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CalendarUtilsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testcase_genDate() throws Exception {
        Calendar cal1 = CalendarUtils.getDate(2019, 1, 1);
        Calendar cal2 = CalendarUtils.getDate(2019, 1, 1);
//        boolean res = cal1.getTimeInMillis() == cal2.getTimeInMillis();
//        System.out.println(res);
        CalendarUtils.dump(cal1);
        CalendarUtils.dump(cal2);

        assertEquals(cal1, cal2);
    }

    @Test
    public void testcaseDateTime() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());

        long dayDate = CalendarUtils.getTime(calendar);
        long dayTime = CalendarUtils.getDate(calendar).getTimeInMillis();

        TimeDump.dump(new Date(dayTime));
        TimeDump.dump(new Date(dayDate));
    }
}