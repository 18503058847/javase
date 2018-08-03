package com.wjl.utils;

import java.lang.management.MemoryManagerMXBean;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Package: com.wjl.utils
 * @ClassName: DateUtils
 * @Description: 日期工具类
 * @Author: 王建岭
 * @CreateDate: 2018/8/3 下午10:29
 */
public class DateUtils {

    public static final SimpleDateFormat FORMAT_YMD = new SimpleDateFormat( "yyyy-MM-dd");
    public static final SimpleDateFormat FORMAT_YMDHMS = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(convertDateToString(date,1));
        System.out.println(convertDateToString(date,2));
        System.out.println(convertDateToString(date,3));

    }

    // 字符串转日期
    public Date formatStringToDate(String str){
        if(str == null){
            return new Date();
        }

        SimpleDateFormat format = new SimpleDateFormat("今天是"+"yyyy年MM月dd日 E kk点mm分");
       // format.format()
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

}

