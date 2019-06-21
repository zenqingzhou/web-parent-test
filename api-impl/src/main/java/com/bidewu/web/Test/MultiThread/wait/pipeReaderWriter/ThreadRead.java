package com.bidewu.web.Test.MultiThread.wait.pipeReaderWriter;


import java.io.PipedReader;

/**
 * Created by zengqingzhou on 2019/6/19.
 */
public class ThreadRead extends Thread{
    private ReadData readData;
    private PipedReader reader;

    public ThreadRead(ReadData readData, PipedReader reader) {
        this.readData = readData;
        this.reader = reader;
    }

    @Override
    public void run() {
        super.run();
        readData.readMethod(reader);
    }
}
