package com.demo.financial;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * @ClassName 复利
 * @Description TODO
 * @Author liujianko
 * @Date 2019/8/14
 **/
public class FuLi {

    /**
     *
     * @param len 年限
     * @param baseMoney 定投金额
     * @param lilv 利率 转成小数点的：3% -> 0.03
     * @return
     */
    public static long getAll(int len, int baseMoney, double lilv){
        BigDecimal js = new BigDecimal(baseMoney);
        BigDecimal fl = new BigDecimal(1 + lilv);
        BigDecimal money = new BigDecimal(0);

        for (int i = 1; i <= len; i++) {
            if (i <= 30) {
                money = money.add(js);
            }
            money = money.multiply(fl, MathContext.DECIMAL32);
            System.out.println("第" + i + "年：" + money);
        }

        return money.longValue();
    }
}
