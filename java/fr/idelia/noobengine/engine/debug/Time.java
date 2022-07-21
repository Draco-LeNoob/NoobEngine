package fr.idelia.noobengine.engine.debug;

import java.time.LocalDateTime;

public class Time {
    private static LocalDateTime time;

    private static void updateTime(){ time = LocalDateTime.now(); }

    public static int getYear(){
        updateTime();
        return time.getYear();
    }
    public static int getMonth(){
        updateTime();
        return time.getMonthValue();
    }
    public static int getDay(){
        updateTime();
        return time.getDayOfMonth();
    }

    public static int getHour(){
        updateTime();
        return time.getHour();
    }
    public static int getMinute(){
        updateTime();
        return time.getMinute();
    }
    public static int getSecond(){
        updateTime();
        return time.getSecond();
    }

    public static String timeToString(){ return "[" + getHour() + ":" + getMinute() + ":" + getSecond() + "]"; }
    public static String dateToString(){ return "[" + getYear() + "-" + getMonth() + "-" + getDay() + "]"; }
}