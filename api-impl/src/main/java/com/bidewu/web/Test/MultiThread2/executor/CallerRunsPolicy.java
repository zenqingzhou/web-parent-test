package com.bidewu.web.Test.MultiThread2.executor;

import java.util.concurrent.*;

/**
 * @Author Created by zengqingzhou on 2019/10/10.
 */
public class CallerRunsPolicy {
    public static void main(String[] args) {

        int count = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(count, count+1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(3));
        //退回调用者
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //抛弃最旧策略(含有异常)
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        BoundedExecutor boundedExecutor = new BoundedExecutor(executor, new Semaphore(5));
        int i = 0;
        try {
            while (true){
                i++;
                System.out.println(i);
                boundedExecutor.submitTask(()->{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(11111);
                });
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
