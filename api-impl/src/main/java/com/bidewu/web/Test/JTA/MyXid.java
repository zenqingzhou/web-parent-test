package com.bidewu.web.Test.JTA;

import lombok.Data;

import javax.transaction.xa.Xid;

/**
 * @Author Created by zengqingzhou on 2019/9/23.
 */
@Data
public class MyXid implements Xid {

    public int formatId;
    public byte gtrid[];
    public byte bqual[];

    public MyXid(){

    }

    @Override
    public int getFormatId() {
        return formatId;
    }

    @Override
    public byte[] getGlobalTransactionId() {
        return gtrid;
    }

    @Override
    public byte[] getBranchQualifier() {
        return bqual;
    }
}
