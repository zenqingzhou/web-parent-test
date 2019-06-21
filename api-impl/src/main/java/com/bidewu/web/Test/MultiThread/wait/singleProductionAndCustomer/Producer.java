package com.bidewu.web.Test.MultiThread.wait.singleProductionAndCustomer;

/**
 *  
 * @Description：生产者
 *
 * @Author zengqingzhou
 * @Date 2019/6/19 11:02
 */
public class Producer {
    private String lock;
    public Producer(String lock){
        super();
        this.lock = lock;
    }

    public void setValue(){
        try {
            synchronized (lock){
                if (!ValueObject.value.equals("")){
                    lock.wait();
                }
                String value = System.currentTimeMillis()+"";
                System.out.println("producer: "+ value);
                ValueObject.value = value;
                lock.notify();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
