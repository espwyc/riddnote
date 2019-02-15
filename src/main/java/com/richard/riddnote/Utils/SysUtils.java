package com.richard.riddnote.Utils;


import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public abstract class SysUtils {

    public static String uid() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取当前时间的零点
     *
     * @return
     */
    public static Date todayZeroTime() {
        Calendar now = Calendar.getInstance();
        now.set(Calendar.HOUR_OF_DAY, 0);
        now.set(Calendar.MINUTE, 0);
        now.set(Calendar.SECOND, 0);
        return now.getTime();

    }

    /**
     * 根据传入的时间获取零点
     *
     * @param dateTime
     * @return
     */
    public static Date zeroTime(Date dateTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static Date firstDayOfThisWeek() {
        LocalDate date = LocalDate.now().with(DayOfWeek.MONDAY);
        return Date.from(date.atStartOfDay(ZoneId.of("Asia/Shanghai")).toInstant());
    }

    public static Date lastDayOfThisWeek() {
        LocalDate date = LocalDate.now().with(DayOfWeek.SUNDAY);
        return Date.from(date.atStartOfDay(ZoneId.of("Asia/Shanghai")).toInstant());
    }

    public static Date lastDayOfLastWeek() {
        LocalDate date = LocalDate.now().with(DayOfWeek.SUNDAY);
        return Date.from(date.plusWeeks(-1).atStartOfDay(ZoneId.of("Asia/Shanghai")).toInstant());
    }

    public static Date firstDayOfThisMonth() {
        LocalDate date = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        return Date.from(date.atStartOfDay(ZoneId.of("Asia/Shanghai")).toInstant());
    }

    public static Date lastDayOfThisMonth() {
        LocalDate date = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        return Date.from(date.atStartOfDay(ZoneId.of("Asia/Shanghai")).toInstant());
    }

    public static Date lastDayOfLastMonth() {
        LocalDate date = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        LocalDate lastMonth = date.plusMonths(-1);
        date = lastMonth.with(TemporalAdjusters.lastDayOfMonth());
        return Date.from(date.atStartOfDay(ZoneId.of("Asia/Shanghai")).toInstant());
    }

    public static Date firstDayOfThisYear() {
        LocalDate date = LocalDate.now().with(TemporalAdjusters.lastDayOfYear());
        LocalDate lastYear = date.plusYears(-1);
        date = lastYear.with(TemporalAdjusters.lastDayOfYear()).plusDays(1);
        return Date.from(date.atStartOfDay(ZoneId.of("Asia/Shanghai")).toInstant());
    }

    public static Date lastDayOfThisYear() {
        LocalDate date = LocalDate.now().with(TemporalAdjusters.lastDayOfYear());
        return Date.from(date.atStartOfDay(ZoneId.of("Asia/Shanghai")).toInstant());
    }

    public static Date lastDayOfLastYear() {
        LocalDate date = LocalDate.now().with(TemporalAdjusters.lastDayOfYear());
        LocalDate lastYear = date.plusYears(-1);
        date = lastYear.with(TemporalAdjusters.lastDayOfYear());
        return Date.from(date.atStartOfDay(ZoneId.of("Asia/Shanghai")).toInstant());
    }

    public static String formatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern(format);
        return sdf.format(date);
    }

    public static ArrayList<Date> getLast12Month() {
        ArrayList<Date> months = new ArrayList<>();
        Date thisMonthFirstDay = firstDayOfThisMonth();
        months.add(thisMonthFirstDay);
        for (int i = 1; i <= 11; i++) {
            Date temp = DateUtils.addMonths(thisMonthFirstDay, -i);
            months.add(temp);
        }
        return months;
    }

    public static ArrayList<Date> getAllDayOfThisMonth() {
        ArrayList<Date> days = new ArrayList<>();

        Date lastDayOfThisMonth = lastDayOfThisMonth();
        Date firstDayOfThisMonth = firstDayOfThisMonth();
        days.add(firstDayOfThisMonth);
        Date tmp = DateUtils.addDays(firstDayOfThisMonth, 1);
        while (tmp.before(lastDayOfThisMonth)) {
            days.add(tmp);
            tmp = DateUtils.addDays(tmp, 1);
        }
        days.add(lastDayOfThisMonth);

        return days;
    }

    public static ArrayList<Date> getAllDayOfThisWeek() {
        ArrayList<Date> days = new ArrayList<>();

        Date lastDayOfThisWeek = lastDayOfThisWeek();
        Date firstDayOfThisWeek = firstDayOfThisWeek();
        days.add(firstDayOfThisWeek);
        Date tmp = DateUtils.addDays(firstDayOfThisWeek, 1);
        while (tmp.before(lastDayOfThisWeek)) {
            days.add(tmp);
            tmp = DateUtils.addDays(tmp, 1);
        }
        days.add(lastDayOfThisWeek);
        return days;
    }
}
