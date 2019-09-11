package com.bidewu.web.Test.DynamicProxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @Author Created by zengqingzhou on 2019/9/11.
 */
public class Client{
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloService.class);
        enhancer.setCallback(new MyMethodInterceptor());
        HelloService helloService = (HelloService) enhancer.create();
        helloService.sayHello();
        helloService.sayOthers("11");
    }
}
