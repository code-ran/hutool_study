package com.ransibi.DateUtil;

import cn.hutool.core.date.*;
import cn.hutool.core.lang.Console;

import java.util.Calendar;
import java.util.Date;

/**
 * @description: 日期时间工具类
 * @author: rsb
 * @description: 2022-12-20-16-29
 * @description: 日期时间工具类
 * @Version: 1.0.0
 */
public class Demo02 {
    /**
     * Hutool针对JDK中Date和Calendar对象的封装
     *
     * @param args
     */
    public static void main(String[] args) {
        DateUtil();

    }

    /**
     * 日期时间工具-DateUtil
     */
    public static void DateUtil() {
        /**
         *Date、long、Calendar之间的相互转换
         */
        Date date = DateUtil.date();
        //Calendar转Date
        Date date1 = DateUtil.date(Calendar.getInstance());
        //long转Date -- 时间戳转Date
        Date date2 = DateUtil.date(System.currentTimeMillis());
        //当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
        //当前日期字符串，格式：yyyy-MM-dd
        String today = DateUtil.today();
//------------------------------------------------------------------------------------------

        /**
         * 字符串转日期
         */
        String dateStr = "2022-03-01";
        //自动识别时间格式
        //2022-03-01 00:00:00
        Date date3 = DateUtil.parse(dateStr);
        //自定义日期格式
        String dateStr1 = "2022-03-01";
        //2022-03-01 00:00:00
        Date date4 = DateUtil.parse(dateStr1, "yyyy-MM-dd");
//-----------------------------------------------------------------------------------------
        /**
         *格式化日期输出
         */
        String dateStr2 = "2017-03-01";
        Date date5 = DateUtil.parse(dateStr2);

        //结果 2017/03/01
        String format = DateUtil.format(date5, "yyyy/MM/dd");

        //常用格式的格式化，结果：2017-03-01
        String formatDate = DateUtil.formatDate(date5);

        //结果：2017-03-01 00:00:00
        String formatDateTime = DateUtil.formatDateTime(date5);

        //结果：00:00:00
        String formatTime = DateUtil.formatTime(date5);
//-------------------------------------------------------------------------------------------

        //获取Date对象的某个部分
        Date date6 = DateUtil.date();
        //获得年的部分
        DateUtil.year(date6);
        //获得月份，从0开始计数
        DateUtil.month(date6);
        DateUtil.dayOfMonth(date6);

//-------------------------------------------------------------------------------------------
        /**
         * 获取当天的开始和结束时间
         */
        String dateStr3 = "2022-03-01 22:33:23";
        Date date7 = DateUtil.parse(dateStr3);

        //一天的开始，结果：2017-03-01 00:00:00
        Date beginOfDay = DateUtil.beginOfDay(date7);

        //一天的结束，结果：2017-03-01 23:59:59
        Date endOfDay = DateUtil.endOfDay(date7);

//-------------------------------------------------------------------------------------------
        /**
         * 日期时间偏移：日期或时间的偏移指针对某个日期增加或减少分、小时、天等等，达到日期变更的目的
         */
        String dateStr4 = "2017-03-01 22:33:23";
        Date date8 = DateUtil.parse(dateStr4);

        //结果：2017-03-03 22:33:23
        //2天后
        Date newDate = DateUtil.offset(date8, DateField.DAY_OF_MONTH, 2);

        //常用偏移，结果：2017-03-04 22:33:23
        //3天后
        DateTime newDate2 = DateUtil.offsetDay(date8, 3);

        //常用偏移，结果：2017-03-01 19:33:23
        //3小时前
        DateTime newDate3 = DateUtil.offsetHour(date8, -3);
        System.out.println(newDate3);
//--------------------------------------------------------------------------------------------

        /**
         * 日期时间差
         */
        String dateStr5 = "2017-03-01 22:33:23";
        Date date9 = DateUtil.parse(dateStr5);
        String dateStr6 = "2017-04-01 23:38:29";
        Date date10 = DateUtil.parse(dateStr6);
        //相差一个月，31天
        long betweenDay = DateUtil.between(date9, date10, DateUnit.DAY);
        //Level.MINUTE表示精确到分
        //31天1小时
        String formatBetween1 = DateUtil.formatBetween(date9, date10, BetweenFormatter.Level.HOUR);
        //31天1小时5分
        String formatBetween2 = DateUtil.formatBetween(date9, date10, BetweenFormatter.Level.MINUTE);
        //31天1小时5分6秒
        String formatBetween3 = DateUtil.formatBetween(date9, date10, BetweenFormatter.Level.SECOND);

        /**
         * 星座和属相
         */
        // "天秤座"
        String zodiac = DateUtil.getZodiac(Month.SEPTEMBER.getValue(), 25);
        // "牛"
        String chineseZodiac = DateUtil.getChineseZodiac(1997);

    }
}
