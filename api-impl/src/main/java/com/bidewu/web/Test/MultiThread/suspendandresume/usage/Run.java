package com.bidewu.web.Test.MultiThread.suspendandresume.usage;

/**
 * Created by zengqingzhou on 2019/6/13.
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(5000);
            //a
            System.out.println("A= " +System.currentTimeMillis()+" i="+ thread.getI());
            Thread.sleep(5000);
            thread.suspend();
            System.out.println("A= " +System.currentTimeMillis()+" i="+ thread.getI());
            //b
            thread.resume();
            Thread.sleep(5000);
            //c
            thread.suspend();
            System.out.println("B= " +System.currentTimeMillis()+" i="+ thread.getI());
            Thread.sleep(5000);
            System.out.println("B= " +System.currentTimeMillis()+" i="+ thread.getI());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
