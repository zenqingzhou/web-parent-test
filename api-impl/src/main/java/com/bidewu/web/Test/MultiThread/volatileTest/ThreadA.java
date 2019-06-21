package com.bidewu.web.Test.MultiThread.volatileTest;

/**
 * Created by zengqingzhou on 2019/6/18.
 */
public class ThreadA extends Thread {
    private Service service;
    public ThreadA(Service service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.runMethod();
    }
}
