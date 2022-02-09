package com.sj.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by thomas(liuxk99@gmail.com) on 2015/3/6.
 * Utilities for Date.
 */
public class DateUtil {
    private static final long MILLISECOND_OF_DAY = 24 * 3600 * 1000L;

    public final static String GMT8_TIMEZONE = "GMT+8:00";

    public static final String DATE_FORMAT_YMD1 = "yyyy-MM-dd";
    public static final String DATE_FORMAT_YMD2 = "yyyyMMdd";
    public static final String FULL_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final SimpleDateFormat dateFormatHHmm = new SimpleDateFormat("HH:mm", Locale.CHINA);

    public static SimpleDateFormat getCommonSimpleDateFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(FULL_TIME_FORMAT, Locale.getDefault());
        dateFormat.setTimeZone(TimeZone.getTimeZone(GMT8_TIMEZONE));
        return dateFormat;
    }

    public static Calendar getCommonCalendar() {
        TimeZone timeZone = TimeZone.getTimeZone(GMT8_TIMEZONE);
        Calendar calPlay = Calendar.getInstance();
        calPlay.setTimeZone(timeZone);
        return calPlay;
    }

    /*
     * Return current time according HH:mm
     */
    public static String getCurrentTimeByHHmm() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FULL_TIME_FORMAT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(GMT8_TIMEZONE));
        return simpleDateFormat.format(Calendar.getInstance().getTime());
    }

    public static String getCurrentDateString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT_YMD1);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(GMT8_TIMEZONE));
        return simpleDateFormat.format(Calendar.getInstance().getTime());
    }

    public static Date nextDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime() + MILLISECOND_OF_DAY);
        return cal.getTime();
    }

    public static Date prevDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime() - MILLISECOND_OF_DAY);
        return cal.getTime();
    }

    public static Date tomorrow() {
        return nextDay(new Date());
    }

    public static Date yesterday() {
        return prevDay(new Date());
    }

    public static Date getDate() {
        return getDate(new Date());
    }

    public static Date getDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static int getPrevOrNextDate(long timeMs) {
        Date dateToday = getDate();
        int date = 0;
        long timeDis = timeMs - dateToday.getTime();
        if (timeDis % MILLISECOND_OF_DAY == 0) {
            date = (int) (timeDis / MILLISECOND_OF_DAY);
        } else {
            if (timeDis > 0) {
                date = (int) (timeDis / MILLISECOND_OF_DAY);
            }
            if (timeDis < 0) {
                date = (int) (timeDis / MILLISECOND_OF_DAY) - 1;
            }
        }
        return date;
    }

    public static String timeMsToString(long timeMs) {
        return dateFormatHHmm.format(new Date(timeMs));
    }

    public static final String GMT_FORMAT = "EEE, dd MMM yyyy HH:mm:ss";
    public static final String SUFFIX_GMT = " GMT";

    public static String getGMTString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(GMT_FORMAT, Locale.US);
        return sdf.format(date) + SUFFIX_GMT;
    }

    private static final String ISO_8601_DF = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static String toISO8601(Date date) {
        return toISO8601(date, Locale.getDefault());
    }

    public static String toISO8601(Date date, Locale locale) {
        final DateFormat sdf_iso_8601 = new SimpleDateFormat(ISO_8601_DF, locale);
        return sdf_iso_8601.format(date);
    }

    public static Date fromISO8601(String str) throws ParseException {
        final DateFormat sdf_iso_8601 = new SimpleDateFormat(ISO_8601_DF, Locale.getDefault());
        return sdf_iso_8601.parse(str);
    }

    public static boolean isSameDay(Date date1, Date date2) {
        return date1.getYear() == date2.getYear()
            && date1.getMonth() == date2.getMonth()
            && date1.getDay() == date2.getDay();
    }
}
