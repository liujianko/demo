package com.demo.Java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ListDemo
 * @Description TODO
 * @Author liujianko
 * @Date 2020/1/6
 **/
public class ListDemo {

    @Test
    public void test1(){

        List list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.stream().forEach(i -> {
            System.out.println(i);
        });

        list.add(3,5);
        list.stream().forEach(i -> {
            System.out.println(i);
        });
    }
}
