package com.bidewu.web.Test.MultiThread.suspendandresume.defect.duzhan;

/**
 * Created by zengqingzhou on 2019/6/13.
 */
public class Run {
    public static void main(String[] args) {
        try {
            final SynchronizedObject object = new SynchronizedObject();
            Thread threadl = new Thread() {
                @Override
                public void run() {
                    object.printString();
                }
            };
            threadl.setName("a");
            threadl.start();
            Thread.sleep(1000);
            Thread thread2 = new Thread() {
                @Override
                public void run(){
                    System.out.println("thread2 启动了，但进入不了 printString() 方法！只打印1个begin");
                    System.out.println("因为printString()方法被a线程锁定并且永远suspend暂停了！");
                    object.printString();
                }
            };
            thread2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
