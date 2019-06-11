package com.bidewu.web.Test.MultiThread;

import net.jcip.annotations.ThreadSafe;

import java.util.Vector;

/**
 * Created by zengqingzhou on 2019/6/11.
 */
@ThreadSafe
public class BetterVector<E> extends Vector<E> {
    public synchronized boolean putIfAbsent(E x){
        boolean absent = !contains(x);
        if (absent){
            add(x);
        }
        return absent;
    }

}
