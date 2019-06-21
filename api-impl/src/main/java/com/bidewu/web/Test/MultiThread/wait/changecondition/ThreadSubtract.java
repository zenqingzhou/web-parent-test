package com.bidewu.web.Test.MultiThread.wait.changecondition;

/**
 * Created by zengqingzhou on 2019/6/18.
 */
public class ThreadSubtract extends Thread {
    private Subtract r;

    public ThreadSubtract(Subtract r){
        super();
        this.r = r;
    }

    @Override
    public void run() {
        super.run();
        r.subtract();
    }
}
