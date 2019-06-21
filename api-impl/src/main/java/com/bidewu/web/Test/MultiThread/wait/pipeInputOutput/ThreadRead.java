package com.bidewu.web.Test.MultiThread.wait.pipeInputOutput;

import java.io.PipedInputStream;

/**
 * Created by zengqingzhou on 2019/6/19.
 */
public class ThreadRead extends Thread{
    private ReadData readData;
    private PipedInputStream inputStream;

    public ThreadRead(ReadData readData, PipedInputStream inputStream) {
        this.readData = readData;
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        super.run();
        readData.readMethod(inputStream);
    }
}
