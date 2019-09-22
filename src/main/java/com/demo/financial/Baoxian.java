package com.demo.financial;

import java.math.BigDecimal;
import java.math.MathContext;

public class Baoxian {

    public static void main(String[] args) {
//        BigDecimal js = new BigDecimal(4140);
//        BigDecimal fl = new BigDecimal(1.03);
//        BigDecimal money = new BigDecimal(0);
//        int year = 40;
//
//        for (int i = 1; i <= year; i++) {
//            if (i <= 30) {
//                money = money.add(js);
//            }
//            money = money.multiply(fl, MathContext.DECIMAL32);
//            System.out.println("第" + i + "年：" + money);
//        }


        BigDecimal b1 = new BigDecimal(0.4);
        BigDecimal b2 = new BigDecimal(0.3);
        BigDecimal b3 = new BigDecimal(0.2);
        BigDecimal b4 = new BigDecimal(0.1);

        double money = 8639.01 - 800;

        BigDecimal m = new BigDecimal(money);

        System.out.println(m.multiply(b1, MathContext.DECIMAL32));
        System.out.println(m.multiply(b2,MathContext.DECIMAL32));
        System.out.println(m.multiply(b3,MathContext.DECIMAL32));
        System.out.println(m.multiply(b4,MathContext.DECIMAL32));
    }
}
