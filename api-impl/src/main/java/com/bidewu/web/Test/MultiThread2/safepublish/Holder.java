package com.bidewu.web.Test.MultiThread2.safepublish;

/**
 * @Author Created by zengqingzhou on 2019/9/25.
 */
public class Holder {
    private int n;
    public Holder(int n){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.n = n;
    }
    public void assertSanity(){
        System.out.println(n);
        if (n != n){
            throw new AssertionError("this statement is false");
        }
    }
}
