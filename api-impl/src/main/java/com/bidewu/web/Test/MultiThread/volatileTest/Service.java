package com.bidewu.web.Test.MultiThread.volatileTest;

/**
 * Created by zengqingzhou on 2019/6/18.
 */
public class Service {
    volatile private boolean  isContinueRun = true;
    public void runMethod(){
        while (isContinueRun == true){
//            synchronized (this){
//
//            }
        }
        System.out.println("stop!");
    }

    public void stopMethod(){
        isContinueRun = false;
    }
}
