package com.bidewu.web.common.constant.auth;


import com.bidewu.web.common.constant.base.IntBaseType;

/**
 * Created by wk on 2019/2/21.
 */

public enum RoleEum implements IntBaseType {


    CONSULTANTS(601, "咨询师"),
    SERVICE(602, "客服"),
    SENIOR_CONSULTANTS(603, "高级咨询师"),
    ;

    private int value;
    private String desc;

    RoleEum(int value, String desc) {
        this.value = value;
        this.desc = desc;
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
