package com.bidewu.web.Test.MultiThread.suspendandresume.defect.duzhan;

/**
 * Created by zengqingzhou on 2019/6/13.
 */
public class SynchronizedObject {
    synchronized public void printString(){
        System.out.println("begin");
        if (Thread.currentThread().getName().equals("a")){
            System.out.println("a线程永远的终止了!");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }
}
