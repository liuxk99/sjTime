package com.sj.time;

import org.junit.Test;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
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
    public void testcase_Default() {
        TimeZone tz = TimeZone.getDefault();
        dumpTimezone(tz);
    }

    private void dumpTimezone(TimeZone tz) {
        System.out.println("---");
        System.out.println(tz);
        System.out.println("id: " + tz.getID());
        System.out.println("displayName: " + tz.getDisplayName());
        System.out.println("offset: " + tz.getRawOffset());
        System.out.println("---");
    }

    @Test
    public void testcase_availableIDs() {
        int i = 0;
        for (String str : TimeZone.getAvailableIDs()) {
            System.out.println("idx: " + i + ", id: " + str);
            i++;
//            TimeZone tz = TimeZone.getTimeZone(str);
//            dumpTimezone(tz);
        }
    }

    @Test
    public void testcase_availableIDs_Offset() {
        int offset = 28800000;
        int i = 0;
        for (String str : TimeZone.getAvailableIDs(offset)) {
            System.out.println("idx: " + i + ", id: " + str);
            i++;
//            TimeZone tz = TimeZone.getTimeZone(str);
//            dumpTimezone(tz);
        }
    }

    @Test
    public void testcase_ZoneOffset() {
        // 创建一个 ZoneOffset，例如 UTC+8
        ZoneOffset offset = ZoneOffset.ofHours(8);
        System.out.println("offset: " + offset);

        // 获取 ZoneOffset 的 ID 字符串
        String offsetId = offset.getId();
        System.out.println("id: " + offsetId);

        // 使用 TimeZone 的静态方法 getAvailableIDs 来查找最接近的 TimeZone ID
        String closestTimeZoneId = null;
        int minDifference = Integer.MAX_VALUE;
        for (String tzId : TimeZone.getAvailableIDs()) {
            TimeZone tz = TimeZone.getTimeZone(tzId);
            if (tz.getRawOffset() == offset.getTotalSeconds() * 1000) {
                closestTimeZoneId = tzId;
                break;
            }
            int difference = Math.abs(tz.getRawOffset() - offset.getTotalSeconds() * 1000);
            if (difference < minDifference) {
                minDifference = difference;
                closestTimeZoneId = tzId;
            }
        }

        // 如果找到了匹配的 TimeZone ID，则创建 TimeZone 对象
        if (closestTimeZoneId != null) {
            TimeZone timeZone = TimeZone.getTimeZone(closestTimeZoneId);
            System.out.println("找到的时区: " + timeZone.getID());
        } else {
            System.out.println("没有找到匹配的时区");
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
        for (TimeZone tz : dstTimeZoneList) {
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
        for (TimeZone tz : dstTimeZoneList) {
            System.out.println(" " + tz.getDisplayName(false, TimeZone.SHORT, Locale.getDefault()));
        }
    }

    @Test
    public void testcase_005() {
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println("id: " + timeZone.getID());

        int offset = timeZone.getOffset(System.currentTimeMillis());
        System.out.println("offset: " + offset);
    }

    @Test
    public void testcase_ZoneIds() {
        for (String zoneId : ZoneId.getAvailableZoneIds()) {
            System.out.println(zoneId);
        }
    }

    @Test
    public void testcase_ZonedDateTime() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("当前带时区的日期时间是: " + now);
    }
}
