package com.bidewu.web.Test.MultiThread2.safepublish;

import java.util.Random;

/**
 * @Author Created by zengqingzhou on 2019/10/8.
 */
public class Run {
    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        int i = 0;
        while (i<1000){
            i++;
            new Thread(()->{
                Holder init = unsafePublish.init(new Random().nextInt(10));
                init.assertSanity();
            }).start();

        }
    }
}
