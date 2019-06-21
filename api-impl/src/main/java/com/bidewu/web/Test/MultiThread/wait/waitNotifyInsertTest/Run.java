package com.bidewu.web.Test.MultiThread.wait.waitNotifyInsertTest;

/**
 * Created by zengqingzhou on 2019/6/20.
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        DBTools dbTools = new DBTools();
        for (int i = 0; i < 20; i++) {
            BackupA backupA = new BackupA(dbTools);
            BackupB backupB = new BackupB(dbTools);
            backupA.start();
            backupA.join();
            backupB.start();
        }

    }
}
