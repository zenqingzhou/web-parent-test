package com.bidewu.web.Test.MultiThread.suspendandresume.defect.butongbu;

/**
 * Created by zengqingzhou on 2019/6/14.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        final MyObject myObject = new MyObject();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                myObject.setValue("a","aa");
            }
        };
        thread1.setName("a");
        thread1.start();
        Thread.sleep(500);
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                myObject.printUsernamePassword();
            }
        };
        thread2.start();
    }
}
