package com.demo;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author liujianko
 * @Date 2019/8/28
 **/
public class Demo {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "---" + new Date());
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.SECOND,10);
        Timer timer = new Timer();
        timer.schedule(new Task(), ca.getTime(),2 * 1000);
        System.out.println("111");

        //Timer timer1 = new Timer();
        //timer1.schedule(new Task(), ca.getTime(),3 * 1000);
    }

    static class Task extends TimerTask{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "---" + new Date());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
