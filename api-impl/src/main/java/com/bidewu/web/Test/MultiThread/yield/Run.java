package com.bidewu.web.Test.MultiThread.yield;

/**
 * Created by zengqingzhou on 2019/6/14.
 */
public class Run {
    public static void main(String[] args) {
        Mythread thread = new Mythread();
        thread.start();
    }
}
