package com.bidewu.web.Test.MultiThread.priority.extendpriority;

/**
 * Created by zengqingzhou on 2019/6/14.
 */
public class Run {
    public static void main(String[] args) {
        System.out.println("main thread begin priority="+Thread.currentThread().getPriority());
//        Thread.currentThread().setPriority(6);
        System.out.println("main thread end priority="+Thread.currentThread().getPriority());
        Mythread1 mythread1 = new Mythread1();
        mythread1.start();
    }
}
