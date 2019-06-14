package com.bidewu.web.Test.MultiThread.suspendandresume.defect.duzhan2;

/**
 * Created by zengqingzhou on 2019/6/14.
 */
public class Mythread extends Thread{
    private long i = 0;

    @Override
    public void run() {
        super.run();
        while (true){
            i++;
            System.out.println(i);
        }
    }
}
