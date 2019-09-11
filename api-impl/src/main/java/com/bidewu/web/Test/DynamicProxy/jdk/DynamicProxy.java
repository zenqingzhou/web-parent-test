package com.bidewu.web.Test.DynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author Created by zengqingzhou on 2019/9/11.
 */
public class DynamicProxy implements InvocationHandler {

    private Object interOj;

    public DynamicProxy(Object obj) {
        this.interOj = obj;
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(interOj.getClass().getClassLoader(), interOj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        Object invoke = method.invoke(interOj, args);
        System.out.println("after invoke");
        return invoke;
    }
}
