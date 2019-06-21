package com.bidewu.web.Test.MultiThread.wait.singleProductionAndCustomer;

/**
 * Created by zengqingzhou on 2019/6/19.
 */
public class ThreadC extends Thread{
    private Consumer consumer;

    public ThreadC(Consumer consumer){
        this.consumer = consumer;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            consumer.getValue();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
