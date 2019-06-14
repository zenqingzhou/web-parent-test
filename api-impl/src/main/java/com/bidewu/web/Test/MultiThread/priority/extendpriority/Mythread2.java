package com.bidewu.web.Test.MultiThread.priority.extendpriority;

/**
 * Created by zengqingzhou on 2019/6/14.
 */
public class Mythread2 extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread2 run priority ="+ this.getPriority());
    }
}
