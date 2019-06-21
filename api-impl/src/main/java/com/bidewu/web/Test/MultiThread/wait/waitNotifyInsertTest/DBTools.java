package com.bidewu.web.Test.MultiThread.wait.waitNotifyInsertTest;

/**
 * Created by zengqingzhou on 2019/6/20.
 */
public class DBTools {
    volatile private boolean prevIsA = false;

    synchronized public void backupA(){
        try {
            while (prevIsA==true){
                wait();
            }
            for (int i = 0; i<5; i++){
                System.out.println("★★★★★");
            }
            prevIsA = true;
            notify();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    synchronized public void backupB(){
        try {
            while (prevIsA==false){
                wait();
            }
            for (int i = 0; i<5; i++){
                System.out.println("☆☆☆☆☆");
            }
            prevIsA = false;
            notify();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
