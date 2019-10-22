package com.bidewu.web.Test.MultiThread2.synchronizedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Created by zengqingzhou on 2019/9/27.
 */
public class SynchronizedList {

    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        new Thread(() -> {
            boolean flag = !list.contains("a");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (flag){
                list.add("a");
            }
            System.out.println(flag);
            System.out.println(list);
        }).start();
        new Thread(() -> {
            boolean flag = !list.contains("a");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (flag){
                list.add("a");
            }
            System.out.println(flag);
            System.out.println(list);
        }).start();
        new Thread(() -> {
            boolean flag = !list.contains("a");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (flag){
                list.add("a");
            }
            System.out.println(flag);
            System.out.println(list);
        }).start();
    }
}
