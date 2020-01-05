package com.demo.util;

import static com.demo.util.ResponseTimeUtils.calculateResponseTime;
import static com.demo.util.ResponseTimeUtils.calculateResponseTime2;

/**
 * @ClassName ResponseTimeTest
 * @Description 响应时间测试类
 * @Author liujianko
 * @Date 2020-1-5
 **/
public class ResponseTimeTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        long time = end - start;

        System.out.println(time);
        System.out.println(calculateResponseTime(time));

        //验证分钟级别，4分28秒
        System.out.println(calculateResponseTime(268000));
        //验证小时级别，4小时25分钟6秒
        System.out.println(calculateResponseTime(15906000));

        // 毫秒数转换为xx 天 xx 时 xx 分 xx 秒
        long ms = (1_000 * 60 * 60 * 24 * 2)  // 2 天
                + (1_000 * 60 * 60 * 2) // 2 时
                + (1_000 * 60 * 2) // 2 分
                + (1_000 * 2); // 2 秒
        System.out.println(calculateResponseTime2(ms));

    }
}
