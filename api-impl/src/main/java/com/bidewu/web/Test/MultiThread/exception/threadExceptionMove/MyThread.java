package com.bidewu.web.Test.MultiThread.exception.threadExceptionMove;

/**
 * Created by zengqingzhou on 2019/6/25.
 */
public class MyThread extends Thread{
    private String num = "a";
    public MyThread(){
        super();
    }

    public MyThread(ThreadGroup group, String name){
        super(group, name);
    }

    @Override
    public void run() {
        super.run();
        int numInt = Integer.parseInt(num);
        System.out.println("在线程中打印："+(numInt+1));
    }
}
