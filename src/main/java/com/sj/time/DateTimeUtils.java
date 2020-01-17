package com.sj.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/*
 * Utilities for Time, such as Date, Calendar.
 * */
public class DateTimeUtils {

    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final int MILLISECONDS_PER_SECOND = 1000;

    public static final long SECOND = MILLISECONDS_PER_SECOND;
    public static final long MINUTE = SECOND * SECONDS_PER_MINUTE;
    public static final long HOUR = MINUTE * MINUTES_PER_HOUR;
    public static final long DAY = HOUR * HOURS_PER_DAY;

    public static final long AM_09 = HOUR * 9;
    public static final long PM_05 = HOUR * 17;

    public static long compoundTime(long hour, long min) {
        return hour * HOUR + min * MINUTE;
    }

    static long compoundTime(long hour, long min, long sec) {
        return hour * HOUR + min * MINUTE + sec * SECOND;
    }

    static long[] getTime(long time) {
        long hour = time / HOUR;
        long min = (time - hour * HOUR) / MINUTE;
        return new long[]{hour, min};
    }

    public static String formatRefTime(long time) {
        long hour = time / HOUR;
        long min = (time - hour * HOUR) / MINUTE;
        return String.format(Locale.getDefault(), "%02d:%02d", hour, min);
    }

    public static String formatTime(Date date) {
        return String.format(Locale.getDefault(), "%02d:%02d", date.getHours(), date.getMinutes());
    }

    public static String formatTime(long time) {
        Date date = new Date();
        date.setTime(time);
        return String.format(Locale.getDefault(), "%02d:%02d", date.getHours(), date.getMinutes());
    }

    public static String formatDate(long time) {
        Date date = new Date();
        date.setTime(time);
        return formatDate(date);
    }

    public static String formatDate(Date date) {
        String str;
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
        str = sdf.format(date);
        return str;
    }

    public static long compoundTime(long offset) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.clear();
        calendar.set(year, month, day);
        return calendar.getTimeInMillis() + offset;
    }

    public static long timeInMillisByDate(Date date) {
        return date.getHours() * DateTimeUtils.HOUR + date.getMinutes() * DateTimeUtils.MINUTE + date.getSeconds() * DateTimeUtils.SECOND;
    }

    public static String formatTime(int hour, int minute) {
        return String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
    }

    static final String ISO_9601_DF = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ";

    public static String toISO8601(Date date) {
        final DateFormat sdf_iso_8601 = new SimpleDateFormat(ISO_9601_DF, Locale.getDefault());
        return sdf_iso_8601.format(date);
    }

    public static Date fromISO8601(String str) throws ParseException {
        final DateFormat sdf_iso_8601 = new SimpleDateFormat(ISO_9601_DF, Locale.getDefault());
        return sdf_iso_8601.parse(str);
    }

    public static boolean isSameDay(Date date1, Date date2) {
        return date1.getYear() == date2.getYear()
                && date1.getMonth() == date2.getMonth()
                && date1.getDay() == date2.getDay();
    }

    static public long getDayDate(Date date) {
        long timeInMillis = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        {
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            Calendar cal = (Calendar) calendar.clone();
            cal.clear();
            cal.set(year, month, day);
            timeInMillis = cal.getTimeInMillis();
        }

        return timeInMillis;
    }

    public static long getDayTime(Date date) {
        long tmp = getDayDate(date);
        return date.getTime() - tmp;
    }

    public static int getHour(long refTime) {
        return (int) (refTime / HOUR);
    }

    public static int getMinute(long refTime) {
        return (int) (refTime % HOUR);
    }
}
