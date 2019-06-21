package com.bidewu.web.Test.MultiThread.volatileTest;

/**
 *  
 * @Description：synchronized拥有volatile把参数具有可视性的能力
 *
 * @Author zengqingzhou
 * @Date 2019/6/18 16:51
 */
public class Run {
    public static void main(String[] args) {
        try {
            Service service = new Service();
            ThreadA a = new ThreadA(service);
            a.start();
            Thread.sleep(1000);
            ThreadB b = new ThreadB(service);
            b.start();
            System.out.println("run stop!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
