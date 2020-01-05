package com.demo.Java;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @ClassName BigDecimalDemo
 * @Description TODO
 * @Author liujianko
 * @Date 2019-10-2
 **/
public class BigDecimalDemo {

    @Test
    public void test3(){
        BigDecimal b1 = BigDecimal.valueOf(0.005D);
        BigDecimal b2 = BigDecimal.valueOf(10000D);

        BigDecimal ret1 = b1.multiply(b2, MathContext.DECIMAL32);
        System.out.println(ret1);

        BigDecimal ret2 = b1.multiply(b2).setScale(3, RoundingMode.HALF_UP);
        System.out.println(ret2);
    }

    @Test
    public void test2(){
        BigDecimal b1 = new BigDecimal(113.880D);
        System.out.println(b1);

        BigDecimal b2 = BigDecimal.valueOf(113.880D);
        System.out.println(b2);
    }

    @Test
    public void test1(){
        double d1 = 2000D;
        BigDecimal b1 = new BigDecimal(d1);
        System.out.println(b1.doubleValue());

        double d2 = 0.00025D;
        BigDecimal b2 = new BigDecimal(d2);
        System.out.println(b2.doubleValue());

        double d3 = 0.00025D;
        BigDecimal b3 = BigDecimal.valueOf(d3);
        System.out.println(b3.doubleValue());
    }

}
