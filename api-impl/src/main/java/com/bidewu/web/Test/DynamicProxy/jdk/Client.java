package com.bidewu.web.Test.DynamicProxy.jdk;

/**
 * @Author Created by zengqingzhou on 2019/9/11.
 */
public class Client {
    public static void main(String[] args) {
        MyInterface myInterface = new DynamicProxy(new RealObject()).getProxy();
        System.out.println(myInterface.doSomething());
        myInterface.somethingElse("test");
    }
}
