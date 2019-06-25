package com.bidewu.web.Test.MultiThread.exception.threadGroupException;

/**
 * Created by zengqingzhou on 2019/6/25.
 */
public class MyThread extends Thread {
    private String num;
    public MyThread(ThreadGroup group, String name, String num){
        super(group, name);
        this.num = num;
    }

    @Override
    public void run() {
        super.run();
        int numInt = Integer.parseInt(num);
        while (this.isInterrupted()==false){
            System.out.println("死循环中： "+Thread.currentThread().getName());
        }
    }
}
