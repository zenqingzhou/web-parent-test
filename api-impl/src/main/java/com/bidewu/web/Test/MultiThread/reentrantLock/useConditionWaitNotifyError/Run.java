package com.bidewu.web.Test.MultiThread.reentrantLock.useConditionWaitNotifyError;

/**
 * Created by zengqingzhou on 2019/6/21.
 */
public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        threadA.start();
    }
}
