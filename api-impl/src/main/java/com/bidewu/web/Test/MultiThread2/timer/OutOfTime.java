package com.bidewu.web.Test.MultiThread2.timer;

import java.util.Timer;
import java.util.TimerTask;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @Author Created by zengqingzhou on 2019/10/8.
 */
public class OutOfTime {
    public static void main(String[] args) {
        try {
            Timer timer = new Timer();
            timer.schedule(new ThrowTask(), 1);
            SECONDS.sleep(1);
            timer.schedule(new ThrowTask(), 1);
            SECONDS.sleep(5);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    static class ThrowTask extends TimerTask{
        @Override
        public void run() {
            throw new RuntimeException();
        }
    }
}
