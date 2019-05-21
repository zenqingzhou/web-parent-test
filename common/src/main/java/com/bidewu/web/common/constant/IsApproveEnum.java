package com.bidewu.web.common.constant;


import com.bidewu.web.common.constant.base.IType;
import com.bidewu.web.common.constant.base.IntBaseType;

import java.util.Map;

public enum IsApproveEnum implements IntBaseType {

    Approve1("未发布",0),
    Approve2("已发布",1);

    IsApproveEnum(String description, int value){

        this.desc = description;
        this.value = value;
    }


    private String desc;
    private int value;

    @Override
    public String getDesc() {
        return desc;
    }


    @Override
    public int getValue() {
        return value;
    }

    public static IsApproveEnum getEnum(int type) {
        return IType.get(type, IsApproveEnum.class);
    }
    public static IsApproveEnum getByStr(String desc) {
        return IType.get(desc, IsApproveEnum.class);
    }
    public static Map<String,Integer> getAll() {
        return IType.getAll(IsApproveEnum.class);
    }
}
