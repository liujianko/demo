package com.demo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @ClassName DemoTest
 * @Description TODO
 * @Author liujianko
 * @Date 2019/9/7
 **/
public class DemoTest {

    @Test
    public void test1(){
        String url = "/api/common/getSourceKey";
        System.out.println(url.substring(1));
        System.out.println("aaa".concat(url));
    }

    @Test
    public void test2(){
        if(1==1)
            System.out.println("1确实等于1");

        System.out.println("111");
    }

    /**
     * 字符串转时间戳
     */
    @Test
    public void test3() throws Exception {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        String timeStr = "2019-09-12 17:38:24"; // 12/Sep/2019:17:38:24
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        long timeStamp = sdf.parse(timeStr).getTime();
        System.out.println(timeStamp);
    }

    /**
     * 时间戳转时间
     */
    @Test
    public void test4(){
        String pattern = "yyyy-MM-dd HH:mm:ss";
        long timeStamp = 1568280980000L; // 1568280589000
        Date date = new Date(timeStamp);
        String s = date.toString();
        System.out.println(s);

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String timeStr = sdf.format(date);
        System.out.println(timeStr);
    }

    @Test
    public void test5(){
        String base = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        int cnt = random.nextInt(24);
        System.out.println(cnt);
        char pre = base.charAt(cnt);
        System.out.println(pre);
    }

    @Test
    public void test6(){
        String str = "12345678912345678988";
        System.out.println(str.length());
        System.out.println(str.substring(0,20));
    }
}
