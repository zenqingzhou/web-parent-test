package com.bidewu.web.Test.MultiThread.reentrantLock.useConditionWaitNotifyError;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zengqingzhou on 2019/6/21.
 */
public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void await(){
        try {
//            lock.lock();
            System.out.println("A");
            condition.await();
            System.out.println("B");
        }catch (Exception e){
            e.printStackTrace();
//        }finally {
//            lock.unlock();
        }

    }
}
