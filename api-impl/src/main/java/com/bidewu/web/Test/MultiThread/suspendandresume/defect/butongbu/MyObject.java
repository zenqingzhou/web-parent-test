package com.bidewu.web.Test.MultiThread.suspendandresume.defect.butongbu;

/**
 * Created by zengqingzhou on 2019/6/14.
 */
public class MyObject {
    private String username = "1";
    private String password = "11";
    public void setValue(String u,String p){
        this.username = u;
        if (Thread.currentThread().getName().equals("a")){
            System.out.println("线程a停止!");
            Thread.currentThread().suspend();
        }
        this.password = p;
    }

    public void printUsernamePassword(){
        System.out.println(username+" "+password);
    }
}
