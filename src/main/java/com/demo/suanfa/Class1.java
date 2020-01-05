package com.demo.suanfa;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName 算法题1 两数之和
 * @Description TODO
 * @Author liujianko
 * @Date 2020-1-3
 **/
public class Class1 {

    int[] arr = {2,3,4,5,2};

    @Test
    public void test(){
        HashMap map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
        }

        boolean b = map.containsKey(2);
        System.out.println(b);

        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
