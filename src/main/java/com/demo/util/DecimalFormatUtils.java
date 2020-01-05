package com.demo.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @ClassName BigDecimalFormatUtils
 * @Description BigDecimal 转字符串
 *
 *          适用场景：BigDecimal 生成两位小数位并返回字符串
 *
 * @Author liujianko
 * @Date 2019-10-2
 **/
public class DecimalFormatUtils {

    protected static String PATTERN = "#.00";

    /**
     * 传入 double 类型的数据
     * @param number
     * @return
     */
    public static String decimalFormat(double number){
        return decimalFormat(number,PATTERN);
    }

    public static String decimalFormat(double number, String pattern){
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(number);
    }

    /**
     * （scale）位小数的数据
     * @param num
     * @param scale
     * @return
     */
    public static BigDecimal Half_UP(BigDecimal num, int scale){
        return num.setScale(scale, RoundingMode.HALF_UP);
    }

}
