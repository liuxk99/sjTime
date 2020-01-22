package com.sj.time;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class TimeTestsuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testcaseDays() {
        // Today Date
        Date todayDate = DateUtil.getDate();
        TimeDump.dump(todayDate);

        Calendar calendar = CalendarUtils.getDate(Calendar.getInstance());
        Date dayDate = calendar.getTime();
        TimeDump.dump(dayDate);

        Assert.assertEquals(todayDate, dayDate);
    }

    @Test
    public void testcase_003() {
        Calendar calendar = Calendar.getInstance();
        TimeDump.dump(calendar.getTime());

        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
    }
}
