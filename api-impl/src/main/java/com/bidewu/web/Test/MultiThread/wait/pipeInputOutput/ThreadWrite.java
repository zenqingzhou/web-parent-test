package com.bidewu.web.Test.MultiThread.wait.pipeInputOutput;

import java.io.PipedOutputStream;

/**
 * Created by zengqingzhou on 2019/6/19.
 */
public class ThreadWrite extends Thread{
    private WriteData writeData;
    private PipedOutputStream outputStream;
    public ThreadWrite(WriteData writeData, PipedOutputStream outputStream){
        this.writeData = writeData;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        super.run();
        writeData.writeMethod(outputStream);
    }
}
