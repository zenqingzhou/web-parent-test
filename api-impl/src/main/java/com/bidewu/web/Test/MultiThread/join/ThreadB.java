package com.bidewu.web.Test.MultiThread.join;

/**
 * Created by zengqingzhou on 2019/6/20.
 */
public class ThreadB extends Thread {
    @Override
    synchronized public void run() {
        try {
            super.run();
            System.out.println("begin B ThreadName=" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("end B ThreadName=" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
