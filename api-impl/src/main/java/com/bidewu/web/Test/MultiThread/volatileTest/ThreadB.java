package com.bidewu.web.Test.MultiThread.volatileTest;

/**
 * Created by zengqingzhou on 2019/6/18.
 */
public class ThreadB extends Thread{
    private Service service;
    public ThreadB(Service service){
        super();
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.stopMethod();
    }
}
