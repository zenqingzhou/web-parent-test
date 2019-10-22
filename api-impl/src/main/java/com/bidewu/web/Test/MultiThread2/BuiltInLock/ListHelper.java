package com.bidewu.web.Test.MultiThread2.BuiltInLock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Created by zengqingzhou on 2019/9/27.
 */
public class ListHelper {
    public List<String> list = Collections.synchronizedList(new ArrayList<>());

    public synchronized boolean putIfAbsent(String s){
        boolean absent = !list.contains(s);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (absent){
            list.add(s);
        }
        System.out.println(list);
        return absent;
    }
}
