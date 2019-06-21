package com.bidewu.web.Test.MultiThread.join;

/**
 * Created by zengqingzhou on 2019/6/20.
 */
public class Run {
    public static void main(String[] args) {
        try {
//            ThreadC c = new ThreadC();
            ThreadB b = new ThreadB();
            ThreadA a = new ThreadA(b);
            a.start();
            b.start();
            b.join(2000);
//            c.start();
            System.out.println("main end " + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
