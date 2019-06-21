package com.bidewu.web.Test.MultiThread.synchronize.synchronizeMethodLockObject2;

/**
 * Created by zengqingzhou on 2019/6/14.
 */
public class MyObject {
     synchronized public void methodA(){
        try {
            System.out.println("begin methodA threadName="+Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end endTime="+ System.currentTimeMillis());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    synchronized public void methodB(){
         try {
             System.out.println("begin methodB threadName="+Thread.currentThread().getName()+"beginTime="+System.currentTimeMillis());
             Thread.sleep(5000);
             System.out.println("end");
         }catch (Exception e){
             e.printStackTrace();
         }
    }

}
