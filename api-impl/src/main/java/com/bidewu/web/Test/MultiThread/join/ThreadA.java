package com.bidewu.web.Test.MultiThread.join;

/**
 * Created by zengqingzhou on 2019/6/20.
 */
public class ThreadA extends Thread {
    private ThreadB b;
    public ThreadA(ThreadB b){
        this.b = b;
    }

    @Override
    public void run() {
        super.run();
        try {
            synchronized (b){
                System.out.println("begin A ThreadName=" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("end A ThreadName=" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
