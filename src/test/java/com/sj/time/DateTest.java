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
        DumpUtils.dump(now);

        // Late
        Date realCheckInDate = (Date) now.clone();
        realCheckInDate.setHours(9);
        realCheckInDate.setMinutes(35);
        System.out.println("real check in date: " + realCheckInDate);
    }
}
