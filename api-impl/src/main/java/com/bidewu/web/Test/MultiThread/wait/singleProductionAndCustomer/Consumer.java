package com.bidewu.web.Test.MultiThread.wait.singleProductionAndCustomer;

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
                if (ValueObject.value.equals("")){
                    lock.wait();
                }
                System.out.println("consumer: "+ System.currentTimeMillis());
                ValueObject.value="";
                lock.notify();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
