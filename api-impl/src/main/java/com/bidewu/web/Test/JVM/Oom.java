package com.bidewu.web.Test.JVM;

import java.util.ArrayList;

/**
 * Created by zengqingzhou on 2019/9/10 0:35
 */
public class Oom {
    static class OOMObject {
        public byte[] placeholder = new byte[1024];
    }

    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<>();
        Integer i=0;
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            list.add(new OOMObject());
            System.out.println(i);
        }
    }
}
