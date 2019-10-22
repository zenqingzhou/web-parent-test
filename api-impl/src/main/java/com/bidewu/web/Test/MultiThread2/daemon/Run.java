package com.bidewu.web.Test.MultiThread2.daemon;

/**
 * @Author Created by zengqingzhou on 2019/9/27.
 */
public class Run {

    private static boolean ready;

    private static int number;

    private static class ReaderThread extends Thread{


        @Override
        public void run(){
            System.out.println(ready);
            while (!ready){
//                try {
//                    TimeUnit.MILLISECONDS.sleep(300);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        new Thread(()->{
            Integer i = 0;
            while (true){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i++);
            }
        }, "thread-1").start();

        ReaderThread thread = new ReaderThread();
        thread.setName("thread-2");
        thread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("change number!");
        number = 42;
//        ready = true;

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end!!!");
    }
}
