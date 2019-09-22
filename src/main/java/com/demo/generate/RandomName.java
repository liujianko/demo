package com.demo.generate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @ClassName RandomName
 * @Description 可用作自动生成用户名
 * @Author liujianko
 * @Date 2019/8/14
 **/
public class RandomName {

    /**
     * 随机生成 len 长度的字母和数字
     * @param len
     * @return
     */
    public static String getRandom(int len){
        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < len; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 随机生成 len 长度的字母
     * @param len
     * @return
     */
    public static String getStringRandom(int len){
        String val = "";
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
            val += (char) (random.nextInt(26) + temp);
        }
        return val;
    }

    /**
     * 生成中文
     * @param len
     * @return
     */
    public static String getRandomJianHan(int len) {
         String ret = "";
         for (int i = 0; i < len; i++) {
             String str = null;
             int hightPos, lowPos; // 定义高低位
             Random random = new Random();
             hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
             lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
             byte[] b = new byte[2];
             b[0] = (new Integer(hightPos).byteValue());
             b[1] = (new Integer(lowPos).byteValue());
             try {
                     str = new String(b, "GBK"); // 转成中文
                 } catch (UnsupportedEncodingException ex) {
                     ex.printStackTrace();
                 }
           ret += str;
        }
        return ret;
    }

    private static final char[] CHARS = new char[]{
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '~', '!', '@', '#', '$', '%', '^', '-', '+', '&', '_'
    };

    /**
     * 可随机生成账号密码
     * @param length
     * @return
     */
    public static String randomGenerate(int length) {
        List<String> list = new ArrayList<String>(CHARS.length);
        for (int i = 0; i < CHARS.length; i++) {
            list.add(String.valueOf(CHARS[i]));
        }
        Collections.shuffle(list);

        int count = 0;
        StringBuffer sb = new StringBuffer();
        Random random = new Random(System.nanoTime());
        while (count < length) {
            int i = random.nextInt(list.size());
            sb.append(list.get(i));
            count++;
        }
        return sb.toString();
    }

}
