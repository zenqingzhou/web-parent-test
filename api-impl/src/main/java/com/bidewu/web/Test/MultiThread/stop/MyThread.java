package com.bidewu.web.Test.MultiThread.stop;

/**
 * Created by zengqingzhou on 2019/6/11.
 */
public class MyThread extends Thread {

    private SynchronizedObject object;

    public MyThread(SynchronizedObject object){
        super();
        this.object = object;
    }

    @Override
    public void run(){
        object.printStirng("b","bb");
    }
}
