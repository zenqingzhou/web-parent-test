package com.bidewu.web.Test.MultiThread.synchronize.synchronizeMethodLockObject2;

/**
 * Created by zengqingzhou on 2019/6/14.
 */
public class ThreadB extends Thread {
    private MyObject object;
    public ThreadB(MyObject object){
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodB();
    }
}
