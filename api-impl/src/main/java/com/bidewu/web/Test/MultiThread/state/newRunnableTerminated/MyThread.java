package com.bidewu.web.Test.MultiThread.state.newRunnableTerminated;

/**
 * Created by zengqingzhou on 2019/6/25.
 */
public class MyThread extends Thread {
    public MyThread(){
        System.out.println("构造方法中的状态："+Thread.currentThread().getName()+" "+Thread.currentThread().getState());
    }

    @Override
    public void run() {
        super.run();
        System.out.println("run方法中的状态"+Thread.currentThread().getName()+" "+Thread.currentThread().getState());
    }
}
