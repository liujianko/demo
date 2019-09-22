package com.demo.demo.java8;


import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName Java8
 * @Description TODO
 * @Author liujianko
 * @Date 2019/8/27
 **/
public class Java8 {

    public List<String> list;
    Stream<String> stream;
    Stream<Integer> stream1;

    @Before
    public void buildStream(){
        list = Arrays.asList("a", "b", "c", "d", "e");
        stream = list.stream();
        stream1 = Stream.of(3, 2, 4, 1, 5);
    }

    @Test
    public void test(){
        System.out.println(list);
        System.out.println(stream);
    }

    //forEach 方法接收一个 Lambda 表达式，用来迭代流中的每个数据
    //forEach 属于结束操作
    @Test
    public void forEach(){
        stream.forEach(a -> System.out.print(a));

        System.out.println();

        stream1.forEach(System.out::print);
    }

    //map 用于映射每个元素到对应的结果
    //map 属于中间操作，中间操作返回值是 Stream
    @Test
    public void map(){
        stream1.map(a -> a*a).forEach(System.out::println);
    }

    //filter 用于通过设置的条件过滤出元素
    //filter 属于中间操作
    @Test
    public void filter(){
        stream.filter(a -> a == "c").forEach(System.out::println);
        stream1.filter(a -> a != 3).forEach(System.out::println);
    }

    //limit 用于用于获取指定数量的流
    //limit 属于中间操作
    @Test
    public void limit(){
        stream.limit(3).forEach(System.out::println);
    }

    //sorted 用于对流进行排序
    //sorted 属于中间操作
    @Test
    public void sorted(){
        stream1.sorted().forEach(System.out::println);
        stream.sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    //allMatch：Stream 中全部元素符合传入的 predicate，返回 true
    //anyMatch：Stream 中只要有一个元素符合传入的 predicate，返回 true
    //noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true

    //它们都不是要遍历全部元素才能返回结果。例如 allMatch 只要一个元素不满足条件，就 skip 剩下的所有元素，返回 false。
    //match 属于结束操作
    @Test
    public void match(){
        //boolean result1 = stream.allMatch(a -> a.startsWith("a"));
        boolean result2 = stream.anyMatch(a -> a.startsWith("a"));
        //boolean result3 = stream.noneMatch(a -> a.startsWith("a"));
        //System.out.println(result1);
        System.out.println(result2);
        //System.out.println(result3);
    }

    //reduce 方法根据指定的函数将元素序列累积到某个值。此方法有两个参数：起始, 累加器函数
    //如果有一个List，希望得到所有这些元素和一些初始值的总和。
    @Test
    public void reduce(){
        Integer result = stream1.reduce(0, (a, b) -> a + b);
        System.out.println(result);
    }

    //Collectors类中提供了功能丰富的工具方法
    //toList\toSet\toCollection\toMap\...
    //而这些方法，都需要通过 collect 方法传入。
    @Test
    public void collect(){
        Set<String> set = stream.collect(Collectors.toSet());
        System.out.println(set);
    }

    @Test
    public void forT(){
        IntStream.range(1,5).forEach(System.out::println);
        System.out.println("======");

        Random random = new Random();
        random.ints(1,100).limit(10).forEach(System.out::println);
        System.out.println("======");

        //stream.map(String::toUpperCase).forEach(System.out::println);
        //System.out.println("======");

        List<String> list1 = stream.map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(list1);
    }

}
