package com.bidewu.web.Test.MultiThread2.BuiltInLock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Created by zengqingzhou on 2019/9/27.
 */
public class ListHelper2<String>{
    public List<String> list = Collections.synchronizedList(new ArrayList<>());

    public boolean putIfAbsent(String s){
        synchronized (list){
            boolean absent = !list.contains(s);
            if (absent){
                list.add(s);
            }
            System.out.println(list);
            return absent;
        }
    }
}
