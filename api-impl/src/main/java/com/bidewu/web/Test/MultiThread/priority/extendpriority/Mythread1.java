package com.bidewu.web.Test.MultiThread.priority.extendpriority;

/**
 * Created by zengqingzhou on 2019/6/14.
 */
public class Mythread1 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread1 run priority ="+ this.getPriority());
        Mythread2 thread2 = new Mythread2();
        thread2.start();
    }
}
