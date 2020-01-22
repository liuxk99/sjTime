package com.sj.time;

import org.junit.Test;

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
    public void testcase_DateTime_001() {
        Date now = new Date();
        System.out.println("timeInMs: " + now.getTime());
        TimeDump.dump(now);
        System.out.println();

        long dayDate = DateTimeUtils.getDayDate(now);
        System.out.println("date 1: " + dayDate);
        TimeDump.dump(new Date(dayDate));
        System.out.println();

        long dayTime = DateTimeUtils.getDayTime(now);
        System.out.println("time 1: " + dayTime);
        TimeDump.dump(new Date(dayTime));
        System.out.println();

        long dayTime2 = DateTimeUtils.getDayTime(now);
        System.out.println("time 2: " + dayTime2);
        TimeDump.dump(new Date(dayTime2));
        System.out.println();

        long dayDate2 = DateTimeUtils.getDayDate(now);
        System.out.println("date 2: " + dayDate2);
        System.out.println(new Date(dayDate2));
    }
}