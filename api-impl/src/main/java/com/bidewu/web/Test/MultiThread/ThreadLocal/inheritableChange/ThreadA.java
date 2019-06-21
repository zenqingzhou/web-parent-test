package com.bidewu.web.Test.MultiThread.ThreadLocal.inheritableChange;

/**
 * Created by zengqingzhou on 2019/6/21.
 */
public class ThreadA extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0;i<10;i++){
                System.out.println("在ThreadA线程中取继承值="+ Tools.t1.get());
                Thread.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
