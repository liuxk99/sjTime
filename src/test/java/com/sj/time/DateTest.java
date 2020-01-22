package com.sj.time;

import org.junit.Test;

import java.util.Date;

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
}
