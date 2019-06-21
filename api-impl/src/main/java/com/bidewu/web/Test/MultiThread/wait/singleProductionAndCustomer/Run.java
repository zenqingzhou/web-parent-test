package com.bidewu.web.Test.MultiThread.wait.singleProductionAndCustomer;

/**
 * Created by zengqingzhou on 2019/6/19.
 */
public class Run {
    public static void main(String[] args) {
        String lock = new String("");
        Consumer consumer = new Consumer(lock);
        Producer producer = new Producer(lock);
        ThreadC threadC = new ThreadC(consumer);
        ThreadP threadP = new ThreadP(producer);
        threadC.start();
        threadP.start();
    }
}
