package com.bidewu.web.Test.MultiThread2.Visibility;

/**
 * @Author Created by zengqingzhou on 2019/9/25.
 */
public class NoVisibility {
    private static boolean ready;

    private static int number;

    private static class ReaderThread extends Thread{
        @Override
        public void run(){
            System.out.println(ready);
            while (!ready){
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        number = 42;
        ready = true;
    }
}
