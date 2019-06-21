package com.bidewu.web.Test.MultiThread.wait.pipeInputOutput;

import java.io.PipedInputStream;

/**
 * Created by zengqingzhou on 2019/6/19.
 */
public class ReadData {
    public void readMethod(PipedInputStream input){
        try {
            System.out.println("read:");
            byte[] byteArray = new byte[20];
            int readLength = input.read(byteArray);
            while (readLength !=-1){
                String newData = new String(byteArray, 0 ,readLength);
                System.out.println(newData);
                readLength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
