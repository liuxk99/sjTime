package com.sj.time;

import org.junit.Test;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class TimeZoneTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void testcase_001() {
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(timeZone);
        System.out.println("id: " + timeZone.getID());
        System.out.println("displayName: " + timeZone.getDisplayName());
    }

    @Test
    public void testcase_002() {
        for (String str : TimeZone.getAvailableIDs()) {
            System.out.println(str);
            TimeZone tz = TimeZone.getTimeZone(str);
            System.out.println(" " + tz);
        }
    }

    @Test
    public void testcase_003() {
        final TimeZone defTimeZone = TimeZone.getDefault();
        for (String id : TimeZone.getAvailableIDs()) {
            TimeZone tz = TimeZone.getTimeZone(id);
            if (tz.getRawOffset() == defTimeZone.getRawOffset()) {
                System.out.println(tz);
            }
        }

        System.out.println("----------");
        for (String id : TimeZone.getAvailableIDs(defTimeZone.getRawOffset())) {
            TimeZone tz = TimeZone.getTimeZone(id);
            System.out.println(" " + tz);
        }
    }

    @Test
    public void testcase_004() {
        final TimeZone defTimeZone = TimeZone.getDefault();

        // 夏令时
        List<TimeZone> dstTimeZoneList = new ArrayList<>();
        for (String id : TimeZone.getAvailableIDs()) {
            TimeZone tz = TimeZone.getTimeZone(id);
            if (tz.getDSTSavings() != 0) {
                dstTimeZoneList.add(tz);
            }
        }

        System.out.println("DST size: " + dstTimeZoneList.size());
        for (TimeZone tz: dstTimeZoneList) {
            System.out.println(" " + tz);
        }

        System.out.println("----------");

        // 非夏令时
        List<TimeZone> ndstTimeZoneList = new ArrayList<>();
        for (String id : TimeZone.getAvailableIDs()) {
            TimeZone tz = TimeZone.getTimeZone(id);
            if (tz.getDSTSavings() == 0) {
                ndstTimeZoneList.add(tz);
            }
        }

        System.out.println("Non-DST size: " + ndstTimeZoneList.size());
        for (TimeZone tz: dstTimeZoneList) {
            System.out.println(" " + tz.getDisplayName(false, TimeZone.SHORT, Locale.getDefault()));
        }
    }

    @Test
    public void testcase_005() {
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(timeZone);

        int offset = timeZone.getOffset(System.currentTimeMillis());
        System.out.println("offset: " + offset);
    }

    @Test
    public void testcase_ZoneIds() {
        for (String zoneId: ZoneId.getAvailableZoneIds()) {
            System.out.println(zoneId);
        }
    }
}
