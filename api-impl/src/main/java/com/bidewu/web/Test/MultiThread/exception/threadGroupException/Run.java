package com.bidewu.web.Test.MultiThread.exception.threadGroupException;

/**
 * Created by zengqingzhou on 2019/6/25.
 */
public class Run {
    public static void main(String[] args) {
        MyThreadGroup myThreadGroup = new MyThreadGroup("我的线程组");
        MyThread[] myThreads = new MyThread[10];
        for (int i = 0;i<myThreads.length;i++){
            myThreads[i] = new MyThread(myThreadGroup,"线程"+(i+1),"1");
            myThreads[i].start();
        }

        MyThread newT = new MyThread(myThreadGroup,"报错线程","a");
        newT.start();
    }
}
