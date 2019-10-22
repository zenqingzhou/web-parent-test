package com.bidewu.web.Test.MultiThread2.pooltest;

import lombok.Data;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Created by zengqingzhou on 2019/10/17.
 */
public class Safety {
    public static void main(String[] args) throws Exception {
        testPoolExpansion();
    }


    /**
     * 回调
     * @throws InterruptedException
     */
    public static void testPoolExpansion() throws InterruptedException {
        int MAX_SIZE = 10;
        ExecutorService exec = new ThreadPoolExecutor(MAX_SIZE, MAX_SIZE, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        TestingThreadFactory threadFactory = new TestingThreadFactory();
        for (int i = 0; i < 10 * MAX_SIZE; i++) {
            exec.execute(() -> {
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
        for (int i = 0; i < 20 && threadFactory.numCreated.get() < MAX_SIZE; i++) {
            Thread.sleep(100);
            threadFactory.newThread(() -> {
                System.out.println("hello world!");
            }).start();
        }
        System.out.println(threadFactory.numCreated.get() + " : " + MAX_SIZE);
        exec.shutdown();
    }

    @Data
    static class TestingThreadFactory implements ThreadFactory {
        public final AtomicInteger numCreated = new AtomicInteger();
        private final ThreadFactory factory = Executors.defaultThreadFactory();

        @Override
        public Thread newThread(Runnable r) {
            numCreated.incrementAndGet();
            return factory.newThread(r);
        }
    }
}
