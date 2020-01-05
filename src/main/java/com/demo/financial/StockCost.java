package com.demo.financial;

import com.demo.util.DecimalFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @ClassName StockCost
 * @Description 股票买卖成本计算
 * @Author liujianko
 * @Date 2019-9-19
 **/
public class StockCost {

    @Test
    public void buyTest(){
        // 原有持仓成本
        double oldPrice = 4.352D;

        // 原有持仓数量
        double oldCount = 100D;

        // 买入价格
        double newPrice = 5.87D;

        // 买入数量
        double newCount = 600D;

        // 沪市？深市？
        String type = HS;

        buy(oldPrice,oldCount,newPrice,newCount,type);
    }

    @Test
    public void sellTest(){
        // 原有持仓成本
        double oldPrice = 5.679D;

        // 原有持仓数量
        double oldCount = 600;

        // 卖出价格
        double newPrice = 5.96D;

        // 卖出数量
        double newCount = 500D;

        // 沪市？深市？
        String type = HS;

        sell(oldPrice,oldCount,newPrice,newCount,type);
    }

    // 佣金 万2.5
    protected double YJ = 0.00025D;

    // 印花税 千1
    protected double YHS = 0.001D;

    // 过户费 万0.2
    protected double GHF = 0.00002D;

    // 沪市
    protected String HS = "hs";

    // 深市
    protected String SS = "ss";

    private void buy(double oldPrice, double oldCount, double newPrice, double newCount, String type){
        // 成交金额
        double cjje = calCjje(newPrice,newCount);

        // 佣金
        double yj = calYJ(cjje);

        // 印花税
        double yhs = 0D;

        // 过户费
        double ghf = calGHF(cjje,type);

        // 发生金额 = 成交金额 + 佣金 + 过户费
        double fsje = calFsje(cjje,yj,yhs,ghf,"buy");

        System.out.println("【成交金额】-->" + cjje + "【发生金额】-->" + fsje);
        System.out.println("【佣金】-->" + yj + "【印花税】-->" + yhs + "【过户费】-->" +ghf);

        // 原持有市值
        BigDecimal b1 = BigDecimal.valueOf(calCjje(oldPrice,oldCount));
        BigDecimal b2 = BigDecimal.valueOf(fsje);
        BigDecimal b3 = BigDecimal.valueOf(oldCount + newCount);

        BigDecimal ret = b1.add(b2).divide(b3,3,RoundingMode.HALF_UP);
        System.out.println("【买入后成本】-->" + ret);
    }

    private void sell(double oldPrice, double oldCount, double newPrice, double newCount, String type){
        // 成交金额
        double cjje = calCjje(newPrice,newCount);

        // 佣金
        double yj = calYJ(cjje);

        // 印花税
        double yhs = calYHS(cjje);

        // 过户费
        double ghf = calGHF(cjje,type);

        // 发生金额 = 成交金额 + 佣金 + 过户费
        double fsje = calFsje(cjje,yj,yhs,ghf,"sell");

        System.out.println("【成交金额】-->" + cjje + "【发生金额】-->" + fsje);
        System.out.println("【佣金】-->" + yj + "【印花税】-->" + yhs + "【过户费】-->" +ghf);

        // 持有市值
        BigDecimal b1 = BigDecimal.valueOf(calCjje(oldPrice,oldCount));
        BigDecimal b2 = BigDecimal.valueOf(fsje);
        BigDecimal b3 = BigDecimal.valueOf(oldCount - newCount);

        BigDecimal ret = b1.subtract(b2).divide(b3,3, RoundingMode.HALF_UP);
        System.out.println("【卖出后成本】-->" + ret);
    }

    /**
     * 发生金额计算
     * @param cjje 成交金额
     * @param yj   佣金
     * @param yhs  印花税
     * @param ghf  过户费
     * @return
     */
    private double calFsje(double cjje, double yj, double yhs, double ghf, String option){
        BigDecimal b1 = new BigDecimal(cjje);
        BigDecimal b2 = new BigDecimal(yj);
        BigDecimal b3 = new BigDecimal(yhs);
        BigDecimal b4 = new BigDecimal(ghf);

        BigDecimal ret;
        if (StringUtils.equals("buy",option)){
            ret = DecimalFormatUtils.Half_UP(b1.add(b2).add(b3).add(b4), 2);
        } else {
            ret = DecimalFormatUtils.Half_UP(b1.subtract(b2).subtract(b3).subtract(b4), 2);

        }
        return ret.doubleValue();
    }

    /**
     * 成交金额计算  买入价格 * 买入数量
     * @param price
     * @param count
     * @return
     */
    private double calCjje(double price, double count){
        BigDecimal b1 = new BigDecimal(price);
        BigDecimal b2 = new BigDecimal(count);

        BigDecimal ret = DecimalFormatUtils.Half_UP(b1.multiply(b2), 2);
        return ret.doubleValue();
    }

    /**
     * 过户费计算
     * 沪市买卖需交过户费，深市没有
     * @param money
     * @param type
     * @return
     */
    private double calGHF(double money, String type){
        if (money <= 0 || StringUtils.equals("ss",type))
            return 0.0;

        BigDecimal b1 = BigDecimal.valueOf(money);
        BigDecimal b2 = BigDecimal.valueOf(GHF);
        BigDecimal ret = DecimalFormatUtils.Half_UP(b1.multiply(b2), 2);

        return ret.doubleValue();
    }

    /**
     * 印花税计算
     * 沪深市卖出需交印花税，上交国家
     * @param money
     * @return
     */
    private double calYHS(double money){
        if (money <= 0)
            return 0.0;

        BigDecimal b1 = BigDecimal.valueOf(money);
        BigDecimal b2 = BigDecimal.valueOf(YHS);
        BigDecimal ret = DecimalFormatUtils.Half_UP(b1.multiply(b2), 2);

        return ret.doubleValue();
    }

    /**
     * 佣金计算
     * 佣金=佣金+交易规费，买卖都需要交佣金
     * 东方财富 万2.5，最低5元，也就是说2w以内佣金都是5元
     * @param money
     * @return
     */
    private double calYJ(double money){
        if (money <= 0)
            return 0.0;

        if (money <= 20000)
            return 5.0;

        BigDecimal b1 = BigDecimal.valueOf(money);
        BigDecimal b2 = BigDecimal.valueOf(YJ);
        BigDecimal ret = DecimalFormatUtils.Half_UP(b1.multiply(b2), 2);

        return ret.doubleValue();
    }

}

