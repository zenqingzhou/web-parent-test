package com.bidewu.web.Test.MultiThread.ThreadLocal.inheritableChange;

/**
 * Created by zengqingzhou on 2019/6/21.
 */
public class InheritableThreadLocalExt extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return System.currentTimeMillis();
    }

    @Override
    protected Object childValue(Object parentValue) {
        return parentValue+" 我在子线程中加的!";
    }
}
