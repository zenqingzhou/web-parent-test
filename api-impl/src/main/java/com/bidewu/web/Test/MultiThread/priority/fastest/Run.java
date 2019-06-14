package com.bidewu.web.Test.MultiThread.priority.fastest;


/**
 * Created by zengqingzhou on 2019/6/14.
 */
public class Run {
    public static void main(String[] args) {
        try {
            ThreadA a = new ThreadA();
            a.setPriority(Thread.NORM_PRIORITY-3);
            a.start();
            ThreadB b = new ThreadB();
            b.setPriority(Thread.NORM_PRIORITY+3);
            b.start();
            Thread.sleep(2000);
            a.stop();
            b.stop();
            System.out.println("a="+a.getCount());
            System.out.println("b="+b.getCount());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
