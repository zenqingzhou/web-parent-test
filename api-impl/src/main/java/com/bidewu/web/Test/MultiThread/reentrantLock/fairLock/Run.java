package com.bidewu.web.Test.MultiThread.reentrantLock.fairLock;

/**
 * Created by zengqingzhou on 2019/6/21.
 */
public class Run {
    public static void main(String[] args) {
        final Service service = new Service(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("★线程"+Thread.currentThread().getName()+"运行了");
                service.serviceMethod();
            }
        };

        Thread[] threads = new Thread[10];
        for (int i = 0;i<threads.length;i++){
            threads[i] = new Thread(runnable);
        }

        for (int i = 0;i<threads.length;i++){
            threads[i].start();
        }
    }
}
