package com.bidewu.web.Test.MultiThread2.BuiltInLock;

/**
 * @Author Created by zengqingzhou on 2019/9/27.
 */
public class Run2 {

    public static void main(String[] args) {
        ListHelper2 listHelper = new ListHelper2();
        new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            listHelper.list.add("a");
        }).start();

        new Thread(() -> {
            boolean a = listHelper.putIfAbsent("a");
            System.out.println(a);
        }).start();

        new Thread(() -> {
            boolean a = listHelper.putIfAbsent("a");
            System.out.println(a);
        }).start();
    }

}
