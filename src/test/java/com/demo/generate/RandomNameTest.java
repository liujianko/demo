package com.demo.generate;

public class RandomNameTest {

    public static void main(String[] args){
        String result1 = RandomName.getRandom(8);
        System.out.println(result1);

        String result2 = RandomName.getStringRandom(8);
        System.out.println(result2);

        String result3 = RandomName.getRandomJianHan(5);
        System.out.println(result3);

        String result4 = RandomName.randomGenerate(8);
        System.out.println(result4);
    }
}
