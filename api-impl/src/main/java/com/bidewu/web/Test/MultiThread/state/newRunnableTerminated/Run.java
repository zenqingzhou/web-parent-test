package com.bidewu.web.Test.MultiThread.state.newRunnableTerminated;

/**
 * Created by zengqingzhou on 2019/6/25.
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            System.out.println("main方法状态1: "+ myThread.getName()+" "+myThread.getState());
            Thread.sleep(1000);
            myThread.start();
            Thread.sleep(1000);
            System.out.println("main方法状态2: "+ myThread.getName()+" "+myThread.getState());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
