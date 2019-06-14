package com.bidewu.web.Test.MultiThread.suspendandresume.usage;

import lombok.Data;

/**
 * Created by zengqingzhou on 2019/6/13.
 */
@Data
public class MyThread extends Thread{
    private long i = 0;

    @Override
    public void run(){
        while (true){
            i++;
        }
    }
}
