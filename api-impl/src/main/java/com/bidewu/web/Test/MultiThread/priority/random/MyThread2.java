package com.bidewu.web.Test.MultiThread.priority.random;

import java.util.Random;

/**
 * Created by zengqingzhou on 2019/6/14.
 */
public class MyThread2 extends Thread {
    @Override
    public void run() {
        super.run();
        long beginTime = System.currentTimeMillis();
        for (int i = 0;i<1000;i++){
            Random random = new Random();
            random.nextInt();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("☆☆☆☆☆ thread 2 use time = "+(endTime-beginTime));
    }
}
