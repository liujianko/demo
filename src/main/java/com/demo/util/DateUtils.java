package com.demo.util;

import java.time.LocalDate;

/**
 * @ClassName DateUtils
 * @Description TODO
 * @Author liujianko
 * @Date 2019/8/19
 **/
public class DateUtils {

    public void getToday(){
        //return LocalDate.now();
    }

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        int month = now.getMonthValue();
        System.out.println(month);
    }
}
