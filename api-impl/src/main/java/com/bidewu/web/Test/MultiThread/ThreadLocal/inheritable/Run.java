package com.bidewu.web.Test.MultiThread.ThreadLocal.inheritable;

/**
 * Created by zengqingzhou on 2019/6/21.
 */
public class Run {
    public static void main(String[] args) {
        try {
            for (int i = 0;i<10;i++){
                System.out.println("   在main线程中取继承值="+Tools.t1.get());
                Thread.sleep(200);
            }
            Thread.sleep(5000);
            ThreadA threadA = new ThreadA();
            threadA.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
