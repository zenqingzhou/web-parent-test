package com.bidewu.web.Test.MultiThread.ThreadLocal.inheritable;

/**
 * Created by zengqingzhou on 2019/6/21.
 */
public class InheritableThreadLocalExt extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return System.currentTimeMillis();
    }
}
