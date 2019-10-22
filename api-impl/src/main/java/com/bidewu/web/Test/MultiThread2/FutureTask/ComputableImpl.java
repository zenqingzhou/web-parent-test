package com.bidewu.web.Test.MultiThread2.FutureTask;

import org.apache.commons.lang3.concurrent.Computable;

/**
 * @Author Created by zengqingzhou on 2019/9/29.
 */
public class ComputableImpl implements Computable {
    @Override
    public Object compute(Object arg) throws InterruptedException {
        Thread.sleep(1000);
        return arg;
    }
}
