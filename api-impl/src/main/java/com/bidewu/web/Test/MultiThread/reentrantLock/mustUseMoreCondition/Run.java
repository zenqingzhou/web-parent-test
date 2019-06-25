package com.bidewu.web.Test.MultiThread.reentrantLock.mustUseMoreCondition;

/**
 * Created by zengqingzhou on 2019/6/21.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        ThreadB threadB = new ThreadB(myService);
        threadA.setName("A");
        threadB.setName("B");
        threadA.start();
        threadB.start();
        Thread.sleep(2000);
        myService.signalAll_A();
    }
}
