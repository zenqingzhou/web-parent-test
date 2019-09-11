package com.bidewu.web.Test.DynamicProxy.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author Created by zengqingzhou on 2019/9/11.
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before advice");
        methodProxy.invokeSuper(o,objects);
        System.out.println("after advice");
        return objects;
    }
}
