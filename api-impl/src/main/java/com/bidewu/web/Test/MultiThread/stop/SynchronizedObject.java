package com.bidewu.web.Test.MultiThread.stop;

import lombok.Data;

/**
 * Created by zengqingzhou on 2019/6/11.
 */
@Data
public class SynchronizedObject{
    private String username = "a";

    private String password = "aa";

    synchronized public void printStirng(String username, String password){
        try {
            this.username = username;
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(100000);
            this.password = password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
