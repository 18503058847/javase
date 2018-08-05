package com.wjl.utils;

import java.lang.management.MemoryManagerMXBean;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Package: com.wjl.utils
 * @ClassName: DateUtils
 * @Description: 日期工具类
 * @Author: 王建岭
 * @CreateDate: 2018/8/3 下午10:29
 *
 * remark
 * 时间 1：00：00 == 1970-1-1 1：0：0
 *
 *
 */
public class DateUtils {

    public static final SimpleDateFormat FORMAT_YMD = new SimpleDateFormat( "yyyy-MM-dd");
    public static final SimpleDateFormat FORMAT_YMDHMS = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

    }

    /**
     * 字符串转日期
     * @param str 1-HH:mm:ss 2-yyyy-MM-dd 3-yyyy-MM-dd HH:mm:ss
     * @param type
     * @return
     */
    public static Date convertStringToDate(String str,int type){
        if(str == null){
            return null;
        }

        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            switch(type){
                case 1:
                    return format1.parse(str) ;
                case 2:
                    return format2.parse(str) ;
                case 3:
                     return format3.parse(str) ;
                default:return null;

            }

        } catch (Exception e){
            System.out.println(e.getMessage());

        }

        return null;
    }


    /**
     * 日期转字符串 type 1：HH:mm:ss 2:yyyy-MM-dd  3:yyyy-MM-dd HH:mm:ss
     * @param date
     * @param type
     * @return
     */
    public static String convertDateToString(Date date,int type){
        if(date == null){
            return null;
        }

        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        switch(type){
            case 1:
                return format1.format(date);
            case 2:
                return format2.format(date);
            case 3:
                return format3.format(date);
            default :
                return null;

        }
    }

    /**
     * 将日期和时间合并为日期
     * @param date
     * @param time
     * @return
     */
    public static Date convertDateAndTimeToDate(Date date,Date time){
        if(date == null || time == null){
           return null;
        }

        String t = convertDateToString(date,1);
        String d = convertDateToString(date,2);

        return convertStringToDate(d + " " +t,3);
    }

    /**
     * 给制定日期添加天数
     * @param date
     * @param days 新增的天数
     * @return
     */
    public static Date addDaysToDate(Date date ,int days){
        Calendar instance =  Calendar.getInstance();
        instance.setTime(date);
        instance.set(Calendar.DAY_OF_MONTH,instance.get(Calendar.DAY_OF_MONTH) + days);
        return instance.getTime();
    }

    /**
     * 获取两段时间的重叠时间分钟数
     * @param aBeginTm
     * @param aEndTime
     * @param bBeginTm
     * @param bEndTime
     * @return
     */
    public static float getOverlappingMins(Date aBeginTm,Date aEndTime,Date bBeginTm,Date bEndTime){
        if(aBeginTm == null || aEndTime == null || bBeginTm == null || bEndTime == null){
            return 0f;
        }
        // 两端时间必须有交集
        if(aBeginTm.before(bEndTime) && aEndTime.after(bEndTime)){
            Date beginDate = aBeginTm.after(bBeginTm) ? aBeginTm : bBeginTm;
            Date endDate = aEndTime.before(bEndTime) ? aEndTime : bEndTime;
            return (endDate.getTime() - beginDate.getTime()) / 1000 / 60;
        }

        return 0f;
    }

}

