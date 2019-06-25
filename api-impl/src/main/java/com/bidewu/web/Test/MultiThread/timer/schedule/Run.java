package com.bidewu.web.Test.MultiThread.timer.schedule;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zengqingzhou on 2019/6/24.
 */
public class Run {
    private static Timer timer = new Timer();
    private static int runCount = 0;
    static public class MyTask extends TimerTask{

        @Override
        public void run() {
            try {
                System.out.println("1 begin 运行了 时间为："+new Date());
                Thread.sleep(2000);
                System.out.println("1 end   运行了 时间为："+new Date());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            MyTask myTask = new MyTask();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dataString = "2019-6-24 17:26:00";
            Date dateRef = simpleDateFormat.parse(dataString);
            System.out.println("字符串时间： "+dateRef.toLocaleString()+"当前时间： "+new Date().toLocaleString());
//            timer.schedule(myTask,dateRef,3000);
            timer.scheduleAtFixedRate(myTask,dateRef,3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
