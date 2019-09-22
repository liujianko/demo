package com.demo.io;

import java.io.File;

/**
 * @ClassName FileStreamDemo
 * @Description TODO
 * @Author liujianko
 * @Date 2019/9/4
 **/
public class FileStreamDemo {

    public static void main(String[] args) {
        try {
            String filePath = "E:/fj_transform/word/to2.doc";
            File file = new File(filePath);
            System.out.println(file.getName());
            //FileInputStream fis = new FileInputStream(filePath);
            //FileOutputStream fos = new FileOutputStream(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
