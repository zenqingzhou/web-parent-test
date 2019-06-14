package com.bidewu.web.Test.MultiThread.priority.fastest;

import lombok.Data;

/**
 * Created by zengqingzhou on 2019/6/14.
 */
@Data
public class ThreadB extends Thread {
    private int count = 0;

    @Override
    public void run() {
        super.run();
        while (true){
            count++;
        }
    }
}
