package com.bidewu.web.Test.MultiThread.wait.multiProductionAndCustomer;

/**
 * Created by zengqingzhou on 2019/6/19.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        Consumer consumer = new Consumer(lock);
        Producer producer = new Producer(lock);
        ThreadC[] threadC = new ThreadC[2];
        ThreadP[] threadp = new ThreadP[2];
        for (int i = 0; i < 2; i++) {
            threadC[i] = new ThreadC(consumer);
            threadp[i] = new ThreadP(producer);
            threadC[i].setName("消费者"+(i+1));
            threadp[i].setName("生产者"+(i+1));
            threadp[i].start();
            threadC[i].start();
        }

        Thread.sleep(1000);
        Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadArray);
        for (int i=0;i<threadArray.length;i++){
            System.out.println(threadArray[i].getName()+" "+threadArray[i].getState());
        }
    }
}
