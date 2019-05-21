package com.bidewu.web.common.constant.datarule;


import com.bidewu.web.common.constant.base.IntBaseType;

public enum ValiImageCodeResultEnum implements IntBaseType, CodeEnum{
    IMAGE_CODE_SUCCESS("验证码正确",150),
    IMAGE_CODE_FAIL("验证码错误",151);

    private String desc;
    private int value;

    ValiImageCodeResultEnum(String desc, int value){
        this.desc = desc;
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
