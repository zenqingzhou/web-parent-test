package com.bidewu.web.common.constant.citycustomer.corp;


import com.bidewu.web.common.constant.base.IntBaseType;

public enum CorpExceptionEnum implements IntBaseType {
    PWD_FAIL(20010,"密码错误"),
    AGENTNOTEXIST(20011,"这个id的经纪人不存在");
    Integer value;
    String desc;
    CorpExceptionEnum(Integer value, String desc){
        this.value = value;
        this.desc = desc;
    }
    @Override
    public int getValue(){
        return value;
    }

    @Override
    public String getDesc(){
        return desc;
    }
}
