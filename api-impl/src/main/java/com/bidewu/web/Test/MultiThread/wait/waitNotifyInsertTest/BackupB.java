package com.bidewu.web.Test.MultiThread.wait.waitNotifyInsertTest;

/**
 * Created by zengqingzhou on 2019/6/20.
 */
public class BackupB extends Thread{
    private DBTools dbTools;
    public BackupB(DBTools dbTools){
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        super.run();
        dbTools.backupB();
    }
}
