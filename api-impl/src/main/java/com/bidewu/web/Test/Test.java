package com.bidewu.web.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Created by zengqingzhou on 2019/9/11.
 */
public class Test {
    public static void main(String[] args) {
//        Integer[] integers = new Integer[6];
//        Integer[] one = new Integer[]{1,2,3};
//        Integer[] two = new Integer[]{4,5,6};
//        System.arraycopy(one,1,integers,0,1);
//        System.arraycopy(two,0,integers,one.length,two.length);
//        Arrays.stream(integers).forEach(System.out::println);

//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));

//        long l = Runtime.getRuntime().freeMemory();
//        System.out.println(l/1024/1024);
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        List list = new ArrayList();
//        new Thread(()->{
//            list.add(1);
//            System.out.println(Thread.currentThread().getName()+list.size());
//        },"A").start();            System.out.println(Thread.currentThread().getName()+list.size());
//
//        new Thread(()->{
//            list.add(1);
//            System.out.println(Thread.currentThread().getName()+list.size());
//        },"B").start();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap;
        concurrentHashMap.put(1,2);
        HashMap map =  new HashMap<>();
        map.put(1,1);
    }
}
