package com.bidewu.web.Test.MultiThread.suspendandresume.defect.duzhan2;

/**
 * Created by zengqingzhou on 2019/6/14.
 */
public class Run {
    public static void main(String[] args) {
        try {
            Mythread thread = new Mythread();
            thread.start();
            Thread.sleep(1000);
            thread.suspend();
            System.out.println("main end");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
