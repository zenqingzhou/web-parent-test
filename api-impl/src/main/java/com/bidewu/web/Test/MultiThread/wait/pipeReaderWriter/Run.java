package com.bidewu.web.Test.MultiThread.wait.pipeReaderWriter;

import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by zengqingzhou on 2019/6/19.
 */
public class Run {
    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedWriter pipedWriter = new PipedWriter();
            PipedReader pipedReader = new PipedReader();

//            pipedReader.connect(pipedWriter);
            pipedWriter.connect(pipedReader);

            ThreadRead threadRead = new ThreadRead(readData,pipedReader);
            ThreadWrite threadWrite = new ThreadWrite(writeData,pipedWriter);

            threadRead.start();

            Thread.sleep(2000);

            threadWrite.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
