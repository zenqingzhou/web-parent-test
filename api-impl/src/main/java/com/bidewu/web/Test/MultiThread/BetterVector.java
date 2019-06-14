package com.bidewu.web.Test.MultiThread;

import net.jcip.annotations.ThreadSafe;

import java.util.Vector;

/**
 *  
 * @Description：线程安全缺少即加入
 *
 * @Author zengqingzhou
 * @Date 2019/6/11 15:08
 */
@ThreadSafe
public class BetterVector<E> extends Vector<E> {
    public synchronized boolean putIfAbsent(E x){
        boolean absent = !contains(x);
        if (absent){
            add(x);
        }
        System.out.println();
        return absent;
    }

}
