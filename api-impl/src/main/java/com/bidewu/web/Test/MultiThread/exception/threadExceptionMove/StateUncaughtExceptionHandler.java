package com.bidewu.web.Test.MultiThread.exception.threadExceptionMove;

/**
 * Created by zengqingzhou on 2019/6/25.
 */
public class StateUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("静态的异常处理");
        e.printStackTrace();
    }
}
