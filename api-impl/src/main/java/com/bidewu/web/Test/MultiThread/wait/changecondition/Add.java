package com.bidewu.web.Test.MultiThread.wait.changecondition;


/**
 * Created by zengqingzhou on 2019/6/18.
 */
public class Add {
    private String lock;
    public Add(String lock){
        super();
        this.lock = lock;
    }
    public void add() {
        synchronized (lock){
            ValueObject.list.add("anyString");
            lock.notifyAll();
        }
    }
}
