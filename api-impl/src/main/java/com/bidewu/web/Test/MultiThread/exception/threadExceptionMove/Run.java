package com.bidewu.web.Test.MultiThread.exception.threadExceptionMove;

/**
 * Created by zengqingzhou on 2019/6/25.
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
        MyThread.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
        myThread.start();
    }
}
