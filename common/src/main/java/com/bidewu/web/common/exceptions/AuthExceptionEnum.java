package com.bidewu.web.common.exceptions;


import com.bidewu.web.common.constant.base.IntBaseType;

public enum AuthExceptionEnum implements IntBaseType {
    AUTH_LACK(403,"权限不足");
    Integer value =0;
    String msg = "";
    AuthExceptionEnum(Integer value,String msg){
        this.msg = msg;
        this.value = value;
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public String getDesc() {
        return null;
    }
}
