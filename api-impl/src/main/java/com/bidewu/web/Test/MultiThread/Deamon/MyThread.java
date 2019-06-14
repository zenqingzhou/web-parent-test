package com.bidewu.web.Test.MultiThread.Deamon;

/**
 * Created by zengqingzhou on 2019/6/14.
 */
public class MyThread extends Thread {
    private int i = 0;

    @Override
    public void run() {
        super.run();
        try {
            while (true){
                i++;
                System.out.println("i="+i);
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
