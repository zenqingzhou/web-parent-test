package com.bidewu.web.Test.MultiThread.wait.pipeReaderWriter;

import java.io.PipedWriter;

/**
 * Created by zengqingzhou on 2019/6/19.
 */
public class WriteData {
    public void writeMethod(PipedWriter out) {
        try {
            System.out.println("write:");
            for (int i = 0; i < 200; i++) {
                String outData = "" + (i + 1);
                out.write(outData);
                System.out.println(outData);
            }
            System.out.println();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
