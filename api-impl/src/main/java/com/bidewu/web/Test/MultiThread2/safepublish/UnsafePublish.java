package com.bidewu.web.Test.MultiThread2.safepublish;

/**
 * @Author Created by zengqingzhou on 2019/9/25.
 */
public class UnsafePublish {
    public Holder holder;
    public Holder init(Integer i){
        holder = new Holder(i);
        return holder;
    }
}
