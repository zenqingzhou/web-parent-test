package com.bidewu.web.Test.DynamicProxy.jdk;

/**
 * @Author Created by zengqingzhou on 2019/9/11.
 */
public class RealObject implements MyInterface {
    @Override
    public String doSomething() {
        System.out.println("doSomething");
        return "res";
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse: "+arg);
    }
}
