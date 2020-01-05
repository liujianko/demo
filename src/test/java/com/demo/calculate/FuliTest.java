package com.demo.calculate;

import com.demo.financial.FuLi;

/**
 * @ClassName FuliTest
 * @Description TODO
 * @Author liujianko
 * @Date 2019/8/14
 **/
public class FuliTest {

    public static void main(String[] args) {
        Long result = FuLi.getAll(30, 4000, 0.03);
        System.out.println(result);
    }
}
