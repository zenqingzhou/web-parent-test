package com.bidewu.web.Test.MultiThread.wait.multiProductionAndCustomer;

/**
 *  
 * @Description：消费者
 *
 * @Author zengqingzhou
 * @Date 2019/6/19 11:11
 */
public class Consumer {
    private String lock;
    public Consumer(String lock){
        this.lock = lock;
    }

    public void getValue(){
        try {
            synchronized (lock){
                while (ValueObject.value.equals("")){
                    System.out.println("consumer "+ Thread.currentThread().getName()+" waiting!☆");
                    lock.wait();
                }
                System.out.println("consumer "+ Thread.currentThread().getName()+" running!"+"value="+ValueObject.value);
                ValueObject.value="";
                lock.notifyAll();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
