package com.bidewu.web.Test.MultiThread.stop;

/**
 * Created by zengqingzhou on 2019/6/11.
 */
public class Run {
    public static void main(String[] args) {
        try {
            SynchronizedObject object = new SynchronizedObject();
            MyThread thread = new MyThread(object);
            thread.start();
            Thread.sleep(500);
//            thread.stop();
            thread.interrupt();
//            Thread.currentThread().interrupt();
            thread.interrupt();
            System.out.println(object.getUsername()+" "+object.getPassword());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
