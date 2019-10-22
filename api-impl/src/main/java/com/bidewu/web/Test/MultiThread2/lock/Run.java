package com.bidewu.web.Test.MultiThread2.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Created by zengqingzhou on 2019/10/17.
 */
public class Run {
    public static void main(String[] args) {
//        Lock lock = new ReentrantLock();
//        new Thread(()->{
//            test(lock);
//        }).start();
//
//        new Thread(()->{
//            test(lock);
//        }).start();
    }

    static void test(Lock lock){
        lock.lock();
        try {
            System.out.println(11);
        }finally {
            lock.unlock();
        }
    }
}
