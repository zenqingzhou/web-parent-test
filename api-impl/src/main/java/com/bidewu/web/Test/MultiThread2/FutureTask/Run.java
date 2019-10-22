package com.bidewu.web.Test.MultiThread2.FutureTask;

import org.apache.commons.lang3.concurrent.Computable;

/**
 * @Author Created by zengqingzhou on 2019/9/29.
 */
public class Run {
    public static void main(String[] args) {
        Computable computable = new ComputableImpl();
        Memoizer memoizer = new Memoizer(computable);
        new Thread(()->{
            try {
                Object a = memoizer.compute("a");
                System.out.println(Thread.currentThread().getName()+": "+a.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "ThreadA").start();

        new Thread(()->{
            try {
                Object a = memoizer.compute("a");
                System.out.println(Thread.currentThread().getName()+": "+a.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "ThreadB").start();
    }
}
