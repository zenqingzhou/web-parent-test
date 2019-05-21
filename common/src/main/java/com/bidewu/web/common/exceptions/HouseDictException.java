package com.bidewu.web.common.exceptions;


import com.bidewu.web.common.constant.base.IntBaseType;

public enum HouseDictException implements IntBaseType {

    ACTIVITY_ADD_FAILED("活动添加异常", 50001),
    ACTIVITY_UPDATE_FAILED("活动修改异常", 50002),
    ;

    HouseDictException(String desc, int value) {
        this.desc = desc;
        this.value = value;
    }

    private String desc;
    private int value;

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
