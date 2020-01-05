package com.demo.util;

/**
 * @ClassName ResponTime
 * @Description 计算响应时间
 *
 *          适用场景：需要返回响应时间接口
 *
 * @Author liujianko
 * @Date 2019/9/2
 **/
public class ResponseTimeUtils {

    /**
     * 1s = 1000 ms
     * 1min = 60s * 1000ms
     * 1h = 60min * 60s * 1000ms
     * 1d = 24h * 60min * 60s * 1000ms
     * @param val
     * @return
     */
    public static String calculateResponseTime(long val){
        Double time = 0.0;
        String time_str = "";
        if (val < 1000){ //毫秒级别
            time = (double)val;
            time_str = "ms";
        } else if (val >= 1000 && val < 60*1000){ //秒级别
            time = val / 1000.0;
            time_str = "s";
        } else if (val >= 60*1000 && val < 60*60*1000) { //分钟级别
            time = val / 60 / 1000.0;
            time_str = "m";
        } else if (val >= 60*60*1000 && val < 24*60*60*1000) { //小时级别
            time = val / 60 / 60 / 1000.0;
            time_str = "h";
        }

        return time + time_str;
    }

    /**
     * 毫秒数转换为xx 天 xx 时 xx 分 xx 秒
     * @param val：毫秒数
     * @return
     */
    public static String calculateResponseTime2(long val){
        int ss = 1000;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;

        long day = val / dd;
        long hour = (val - day * dd) / hh;
        long minute = (val - day * dd - hour * hh) / mi;
        long second = (val - day * dd - hour * hh - minute * mi) / ss;
        long milliSecond = val - day * dd - hour * hh - minute * mi - second * ss;

        return day + "天" + hour + "时" + minute + "分" + second + "秒" + milliSecond + "毫秒";

    }
}
