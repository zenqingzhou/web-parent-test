package com.bidewu.web.Test.MultiThread.wait.multiProductionAndCustomer;

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
                while (!ValueObject.value.equals("")){
                    System.out.println("producer "+ Thread.currentThread().getName()+" waiting!★");
                    lock.wait();
                }
                String value = System.currentTimeMillis()+"";
                ValueObject.value = value;
                System.out.println("producer "+ Thread.currentThread().getName()+" running!"+"value="+value);
                lock.notifyAll();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
