package com.bidewu.web.Test.MultiThread.reentrantLock.useConditionWaitNotifyError;

/**
 * Created by zengqingzhou on 2019/6/21.
 */
public class ThreadA extends Thread {
    private MyService myService;
    public ThreadA(MyService myService){
        this.myService = myService;
    }

    @Override
    public void run() {
        super.run();
        myService.await();
    }
}
