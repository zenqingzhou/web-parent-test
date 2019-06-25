package com.bidewu.web.Test.MultiThread.reentrantLock.mustUseMoreCondition;

/**
 * Created by zengqingzhou on 2019/6/21.
 */
public class ThreadB extends Thread {
    private MyService myService;

    public ThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        super.run();
        myService.awaitB();
    }
}
