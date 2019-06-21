package com.bidewu.web.Test.MultiThread.wait.changecondition;

/**
 * Created by zengqingzhou on 2019/6/18.
 */
public class ThreadAdd extends Thread {
    private Add p;

    public ThreadAdd(Add p) {
        super();
        this.p = p;
    }

    @Override
    public void run() {
        super.run();
        p.add();
    }
}
