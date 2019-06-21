package com.bidewu.web.Test.MultiThread.wait.pipeInputOutput;

import java.io.PipedOutputStream;

/**
 * Created by zengqingzhou on 2019/6/19.
 */
public class WriteData {
    public void writeMethod(PipedOutputStream out) {
        try {
            System.out.println("write:");
            for (int i = 0; i < 200; i++) {
                String outData = "" + (i + 1);
                out.write(outData.getBytes());
                System.out.println(outData);
            }
            System.out.println();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
