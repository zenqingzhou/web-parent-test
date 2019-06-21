package com.bidewu.web.Test.MultiThread.synchronize.synchronizeMethodLockObject;

/**
 * Created by zengqingzhou on 2019/6/14.
 */
public class ThreadA extends Thread{
    private MyObject object;
    public ThreadA(MyObject object){
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}
