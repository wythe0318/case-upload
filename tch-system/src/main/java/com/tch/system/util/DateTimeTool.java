package com.tch.system.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author ：Wythe
 * @description：时间转换工具类
 * @date ：2024/03/20 16:22
 */
public class DateTimeTool {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date strToDate(String dateString) throws ParseException {
        return DATE_FORMAT.parse(dateString);
    }

    public static String dateToStr(Date date) {
        return DATE_FORMAT.format(date);
    }

    public static Date addSeconds(Date date, int seconds) {
        long millis = date.getTime();
        millis += seconds * 1000;
        return new Date(millis);
    }

    public static Date subtractSeconds(Date date, int seconds) {
        long millis = date.getTime();
        millis -= seconds * 1000;
        return new Date(millis);
    }

    public static long timeDifference(Date startDate, Date endDate) {
        long startMillis = startDate.getTime();
        long endMillis = endDate.getTime();
        return endMillis - startMillis;
    }

    // 示例用法
    public static void main(String[] args) {
        String dateString = "2019-01-01 10:01:01";
        try {
            Date date = strToDate(dateString);
            System.out.println("Date object: " + date);

            String formattedDate = dateToStr(date);
            System.out.println("Formatted date string: " + formattedDate);

            Date newDate = addSeconds(date, 3600); // Adding one hour (3600 seconds)
            System.out.println("New date after adding 1 hour: " + newDate);

            long timeDifference = timeDifference(date, newDate);
            System.out.println("Time difference between original and new date: " + timeDifference + " milliseconds");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
