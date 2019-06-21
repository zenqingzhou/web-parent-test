package com.bidewu.web.Test.MultiThread.wait.pipeReaderWriter;

import java.io.PipedWriter;

/**
 * Created by zengqingzhou on 2019/6/19.
 */
public class ThreadWrite extends Thread{
    private WriteData writeData;
    private PipedWriter writer;
    public ThreadWrite(WriteData writeData, PipedWriter writer){
        this.writeData = writeData;
        this.writer = writer;
    }

    @Override
    public void run() {
        super.run();
        writeData.writeMethod(writer);
    }
}
