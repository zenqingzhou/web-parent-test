package com.bidewu.web.Test.MultiThread.reentrantLock.fairLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zengqingzhou on 2019/6/21.
 */
public class Service {
    private ReentrantLock lock;
    public Service(boolean isFair){
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod(){
        try {
            lock.lock();
            System.out.println("ThreadName: "+Thread.currentThread().getName()+" 获得了锁");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
