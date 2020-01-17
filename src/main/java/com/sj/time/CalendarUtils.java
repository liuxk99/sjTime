package com.sj.time;

import java.util.Calendar;

public class CalendarUtils {
    public static void dump(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        System.out.println(String.format("%d %04d/%02d/%02d", dayOfWeek, year, month, day));
    }

    public static Calendar getDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        return getDate(calendar, year, month, day);
    }

    private static Calendar getDate(Calendar calendar, int year, int month, int day) {
        Calendar cal = (Calendar) calendar.clone();
        cal.clear();
        cal.set(year, month - 1, day);
        return cal;
    }

    public static Calendar getDate(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        Calendar cal = (Calendar) calendar.clone();
        cal.clear();
        cal.set(year, month, day);
        return cal;
    }

    public static long getTime(Calendar calendar) {
        Calendar cal = getDate(calendar);
        return calendar.getTimeInMillis() - cal.getTimeInMillis();
    }
}
