package com.bidewu.web.Test.MultiThread.wait.multiProductionAndCustomer;

/**
 * Created by zengqingzhou on 2019/6/19.
 */
public class ThreadP extends Thread {
    private Producer producer;

    public ThreadP(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            producer.setValue();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
