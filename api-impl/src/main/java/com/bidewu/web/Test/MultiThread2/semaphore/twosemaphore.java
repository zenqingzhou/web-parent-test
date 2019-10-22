package com.bidewu.web.Test.MultiThread2.semaphore;

import lombok.Data;

import java.util.concurrent.Semaphore;

/**
 * @Author Created by zengqingzhou on 2019/10/16.
 */
public class twosemaphore {
    public static void main(String[] args) {
        semaphore semaphore = new semaphore();
        try {
//            semaphore.semaphore2.acquire();
//            int i = semaphore.semaphore2.drainPermits();
//            System.out.println(i);
//            semaphore.semaphore1.acquire();
//            semaphore.semaphore1.release();
            new Thread(()->{
                try {
                    semaphore.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            new Thread(()->{
                try {
                    semaphore.put();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            semaphore.put();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("semaphore: "+semaphore.semaphore1.availablePermits());
        System.out.println("semaphore2: "+semaphore.semaphore2.availablePermits());
    }

    @Data
    static class semaphore{
        Semaphore semaphore1 = new Semaphore(0);
        Semaphore semaphore2 = new Semaphore(3);

        public void put() throws InterruptedException {
            semaphore2.acquire();
            semaphore1.release();
        }

        public void take() throws InterruptedException {
            semaphore1.acquire();
            semaphore2.release();
        }
    }

}
